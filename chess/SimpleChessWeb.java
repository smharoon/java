import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class SimpleChessWeb {
    static char[][] board = new char[8][8];
    static String turn = "White";

    public static void main(String[] args) throws IOException {
        initializeBoard();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new ChessHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server running at http://localhost:8080/");
    }

    static class ChessHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            if (method.equalsIgnoreCase("POST")) {
                InputStream is = exchange.getRequestBody();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }
                String move = body.toString().replace("move=", "").trim();
                makeMove(move);
                turn = turn.equals("White") ? "Black" : "White";
            }

            String html = generateHtmlPage();
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, html.length());
            OutputStream os = exchange.getResponseBody();
            os.write(html.getBytes());
            os.close();
        }
    }

    public static String generateHtmlPage() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Simple Chess</title></head><body>");
        sb.append("<h1>").append(turn).append("'s Turn</h1>");
        sb.append("<form method='POST'>Move (e.g., e2e4): <input name='move'/><input type='submit'/></form>");
        sb.append("<pre>");
        sb.append("   a b c d e f g h\n");
        sb.append("   _ _ _ _ _ _ _ _\n");
        int row = 8;
        for (int i = 0; i < 8; i++) {
            sb.append(row--).append(" |");
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j]).append("|");
            }
            sb.append("\n");
        }
        sb.append("</pre>");
        sb.append("</body></html>");
        return sb.toString();
    }

    public static void initializeBoard() {
        board[0][0] = board[0][7] = 'r';
        board[0][1] = board[0][6] = 'n';
        board[0][2] = board[0][5] = 'b';
        board[0][3] = 'q';
        board[0][4] = 'k';
        for (int i = 0; i < 8; i++) board[1][i] = 'p';

        board[7][0] = board[7][7] = 'R';
        board[7][1] = board[7][6] = 'N';
        board[7][2] = board[7][5] = 'B';
        board[7][3] = 'Q';
        board[7][4] = 'K';
        for (int i = 0; i < 8; i++) board[6][i] = 'P';

        for (int i = 2; i <= 5; i++)
            for (int j = 0; j < 8; j++)
                board[i][j] = '_';
    }

    public static void makeMove(String move) {
        if (move.length() != 4) return;
        int fromCol = move.charAt(0) - 'a';
        int fromRow = 8 - Character.getNumericValue(move.charAt(1));
        int toCol = move.charAt(2) - 'a';
        int toRow = 8 - Character.getNumericValue(move.charAt(3));
        if (fromCol < 0 || fromCol >= 8 || toCol < 0 || toCol >= 8 ||
            fromRow < 0 || fromRow >= 8 || toRow < 0 || toRow >= 8) return;
        char piece = board[fromRow][fromCol];
        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = '_';
    }
}
