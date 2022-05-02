public class com {
    int eid;
    String name;
    int salary;

    private com(int id, int sal) {
        System.out.println("id is" + id);
        System.out.println("id is" + sal);
    }

    public static void main(String[] args) {
        // com c = new com();
        com c1 = new com(123, 67);
        System.out.println(c1.eid);
    }
}