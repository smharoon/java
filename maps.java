import java.util.HashMap;

public class maps {
    
    public static void main(String [] Args){
        // Map<Integer, String> fruits = new HashMap<Integer, String>();
        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("John", 12345);
        empIds.putIfAbsent("Sam", 2234);
        empIds.replace("Tom",889);
        empIds.put("John", 22311);

        System.out.println(empIds);
        System.out.println(empIds.get("John"));
        // set entries=empIds.entrySet();
        

    }
}
