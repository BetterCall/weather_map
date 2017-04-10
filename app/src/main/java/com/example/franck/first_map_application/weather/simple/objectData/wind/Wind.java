package com.example.franck.first_map_application.weather.simple.objectData.wind;

/**
 * Created by Franck on 07/04/2017.
 */

public class Wind {
    private double speed ;
    private int deg ;

    public Wind(double speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}
