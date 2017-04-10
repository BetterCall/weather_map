package com.example.franck.first_map_application.weather.simple.objectData.rain;

/**
 * Created by Franck on 08/04/2017.
 */

public class Rain {

    private double time ;

    public Rain(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "time=" + time +
                '}';
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
