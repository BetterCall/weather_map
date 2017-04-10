package com.example.franck.first_map_application.weather.simple.objectData.coord;

/**
 * Created by Franck on 07/04/2017.
 */

public class Coord {

    private int lon ;
    private int lat ;

    public Coord(int lon, int lat) {
        this.lon = lon;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }
}
