package com.example.franck.first_map_application.weather.simple.objectData.clouds;

/**
 * Created by Franck on 07/04/2017.
 */

public class Clouds {

    public Clouds(int all) {
        this.all = all;
    }

    private int all ;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
