package com.jworld;
import java.util.*;
import java.util.stream.*;
/**
 * Hello world!
 */
public final class App {
    static int score = 0; 
    static Scanner sc = new Scanner(System.in);

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int ch;
        while (true) {
            readData dbs = new readData();
            ArrayList<countriesClass> countriesList = dbs.readData1();
            // get a random country
            Random random = new Random();
            int x = random.nextInt(200);
            countriesClass countryRandom = countriesList.get(x);
            // send that country to menu
            Menu(countryRandom, countriesList);
            System.out.println("Your Score: " + score);
            
            System.out.println("play again:\n 1: yes\n 2: no");
            ch = sc.nextInt();
            
            if (ch == 2) {
                
                break;
            }

            
        }
        sc.close();
    }

    
    public static void Menu(countriesClass country1, ArrayList<countriesClass> countriesList) {
        
        
        countriesClass country = country1;
        System.out.println(country.capital);
        // getting all the continents
        List<String> continents= countriesList.stream().map(x -> x.region).distinct().collect(Collectors.toList());
        //displaying all the continents
        System.out.println("Pick the continent: ");
        for (int i = 0; i < continents.size()-1; i++) {
            System.out.println(" " + i + ":" + continents.get(i));
        }
        // picking choice
        int ch = sc.nextInt();
        // comparing the choice with the actual value
        if (!country.region.equals(continents.get(ch))) {
            System.out.println("Wrong choice");
            System.out.println("Try again:\n 1: yes\n 2:no");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Menu(country, countriesList);
                    
                    return;
                case 2:
                    
                    return;

            }
        }

        // getting all subregion
        String continentPicked = continents.get(ch);
        List<String> subregions = countriesList.stream().filter(s -> s.region.equals(continentPicked)).map(x -> x.subregion).distinct().collect(Collectors.toList());
        // displaying all the subregions
        System.out.println("Pick the subregion:");
        for (int i = 0; i < subregions.size(); i++) {
            System.out.println(" " + i + ":" + subregions.get(i));
        }
        // picking choice
        ch = sc.nextInt();
        // comparing the choice with the actual value
        if (!country.subregion.equals(subregions.get(ch))) {
            System.out.println("Wrong choice");
            System.out.println("Try again:\n 1: yes\n 2: no");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Menu(country, countriesList);
                    
                    return;
                case 2:
                    
                    return;

            }
        }

        // getting all countries
        String subregionPicked = subregions.get(ch);
        List<String> countries = countriesList.stream().filter(s -> s.subregion.equals(subregionPicked)).map(x -> x.name).distinct().collect(Collectors.toList());
        // displaying all the countries
        System.out.println("Pick the country");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(" " + i + ":" + countries.get(i));
        }
        // picking choice
        ch = sc.nextInt();
        // comparing the choice with the actual value
        if (!country.name.equals(countries.get(ch))) {
            System.out.println("Wrong choice");
            System.out.println("Try again: \n 1: yes\n 2: no");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Menu(country, countriesList);
                    
                case 2:
                    
                    return;
            }
        }


        score = score + 1;
        
        return;
        // dbs.test();
    }

}
