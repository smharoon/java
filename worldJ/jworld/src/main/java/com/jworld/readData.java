package com.jworld;
import java.io.FileReader;
import java.util.ArrayList;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
// import java.util.*;

public class readData {
    ArrayList<countriesClass> readData1(){
        ArrayList<countriesClass> countriesList = new ArrayList<countriesClass>();
        try{
            //List of countriesClass objects
            
            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader(".//jsonfiles//countries.json");
            Object obj = jsonparser.parse(reader);
            JSONArray count = (JSONArray) obj;
            for (int i =0; i < count.size(); i++){
                JSONObject s = (JSONObject)count.get(i);
                // String tempid = (String) s.get("id");
                int id = ((Number) s.get("id")).intValue();
                String name = (String) s.get("name");
                String capital = (String) s.get("capital");
                String region = (String) s.get("region");
                String subregion = (String) s.get("subregion");
                String latitude = (String) s.get("latitude");
                String longitude = (String) s.get("longitude");
                countriesClass obj1 = new countriesClass(id, name, capital, region, subregion, latitude, longitude); 
                countriesList.add(obj1);   
            }
            // System.out.println(countriesList.get(16-1).name);
            
            // System.out.println(name);
       } catch (Exception e){
            System.out.println("EXCE{");
            System.out.println(e);
        }
        return countriesList;
        
    }
    
}
