class data{
    String javaVer, date, highlight;
    public data(String javaVer, String date, String highlight){
        this.javaVer = javaVer;
        this.date = date;
        this.highlight = highlight;
    }
}

class dataArray {
    data T[] = new data[4];
    int count;
    void addData(data T){
        this.T[count] = T;
        count ++;
    }
    void display(){
        System.out.println("Release        Date        Highlights");
        for(int i=0; i<count; i++){
            System.out.println(T[i].javaVer+"      "+T[i].date+"        "+T[i].highlight);
        }
    }  
}

public class array2{
    public static void main(String[] args) {
        data d1 = new data("JAVA SE 5", "2004", "static import");
        data d2 = new data("JAVA SE 6", "2006", "JVM improved");
        data d3 = new data("JAVA SE 7", "2011", "Try Resource");
        data d4 = new data("JAVA SE 8", "2014", "Lambda");
        dataArray da = new dataArray();
        da.count = 0;
        da.addData(d1);
        da.addData(d2);
        da.addData(d3);
        da.addData(d4);
        da.display();
        
    }
}


