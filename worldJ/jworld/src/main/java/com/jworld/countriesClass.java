package com.jworld;



public class countriesClass {
    int id;
    String name;
    String capital;
    String region;
    String subregion;
    String latitude;
    String longitude;
    countriesClass(int id, String name, String capital, String region, String subregion, String latitude, String longitude){
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    int getId(){
        return (this.id);
    }
    String getName(){
        return(this.name);
    }
    String getCapital(){
        return (this.capital);
    }
    String getRegion(){
        return (this.region);
    }
    String getSubregion(){
        return (this.subregion);
    }
}
