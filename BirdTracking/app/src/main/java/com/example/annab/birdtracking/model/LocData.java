package com.example.annab.birdtracking.model;

/**
 * @Author - Pooja Mishra
 * @Desc - POJO to carry Location data
 */

public class LocData {

    //Primary key of the table
    private int id;
    //Lattitude value in string
    private String lat;
    //Longitude value in string
    private String lon;
    //Locality name
    private String locality;

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public LocData() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public LocData(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LocData{" +
                "id=" + id +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
