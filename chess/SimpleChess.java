import java.util.Scanner;
public class SimpleChess {
    static char[][] board = new char[8][8];
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String turn = "White";
        initializeBoard();
        printBoard();
        while (true)
        {
            System.out.println("Enter "+turn+" moves");
            String move = scanner.nextLine();
            makeMove(move);
            printBoard();
            turn = "Black";
        }
        


    }
    public static void initializeBoard() {
        // Set up black pieces
        board[0][0] = board[0][7] = 'r'; // rooks
        board[0][1] = board[0][6] = 'n'; // knights
        board[0][2] = board[0][5] = 'b'; // bishops
        board[0][3] = 'q'; // queen
        board[0][4] = 'k'; // king
        for (int i = 0; i < 8; i++) {
            board[1][i] = 'p'; // pawns
        }

        // Set up white pieces
        board[7][0] = board[7][7] = 'R'; // rooks
        board[7][1] = board[7][6] = 'N'; // knights
        board[7][2] = board[7][5] = 'B'; // bishops
        board[7][3] = 'Q'; // queen
        board[7][4] = 'K'; // king
        for (int i = 0; i < 8; i++) {
            board[6][i] = 'P'; // pawns
        }

        // Empty spaces
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '_';
            }
        }
        
    }
    public static void printBoard() {
        System.out.println("   a b c d e f g h");
        System.out.println("   _ _ _ _ _ _ _ _");
        int row = 8;
        for (int i = 0; i < 8; i++) {
            System.out.print(row--);
            System.out.print(" |");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static void makeMove(String move) {
        // Basic validation (should be 4 characters like d2d4)
        if (move.length() != 4) {
            System.out.println("Invalid move format. Use format like d2d4.");
            return;
        }
    
        // Convert characters to indices
        int fromCol = move.charAt(0) - 'a'; // 'a' = 0, 'b' = 1, ...
        int fromRow = 8 - Character.getNumericValue(move.charAt(1)); // '2' = 6 (row index)
        int toCol = move.charAt(2) - 'a';
        int toRow = 8 - Character.getNumericValue(move.charAt(3));
    
        // Check if positions are within bounds
        if (fromCol < 0 || fromCol >= 8 || toCol < 0 || toCol >= 8 ||
            fromRow < 0 || fromRow >= 8 || toRow < 0 || toRow >= 8) {
            System.out.println("Move out of board bounds.");
            return;
        }
    
        // Perform the move
        char piece = board[fromRow][fromCol];
        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = '_';
    
        // Print the board after move
        
    }
}