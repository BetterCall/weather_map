package com.example.franck.first_map_application.weather.forecast.objectData.list.clouds;

/**
 * Created by Franck on 07/04/2017.
 */

public class Clouds {
    private int all ;

    public Clouds(int all) {
        this.all = all;
    }

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
