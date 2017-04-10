package com.example.franck.first_map_application.weather.simple;


import com.example.franck.first_map_application.weather.simple.objectData.clouds.Clouds;
import com.example.franck.first_map_application.weather.simple.objectData.coord.Coord;
import com.example.franck.first_map_application.weather.simple.objectData.main.Main;
import com.example.franck.first_map_application.weather.simple.objectData.rain.Rain;
import com.example.franck.first_map_application.weather.simple.objectData.sys.Sys;
import com.example.franck.first_map_application.weather.simple.objectData.weather.Weather;
import com.example.franck.first_map_application.weather.simple.objectData.wind.Wind;

import java.util.List;

/**
 * Created by Franck on 07/04/2017.
 */

public class CurrentWeatherData {
    private Coord coord ;
    private List<Weather> weather;
    private String base ;
    private Main main ;
    private Wind wind ;

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    private Rain rain ;
    private Clouds clouds ;
    private long dt ;
    private Sys sys  ;

    private int id ;
    private String name;
    private int cod ;

    public CurrentWeatherData(Coord coord, List<Weather> weather, String base, Main main, Wind wind, Rain rain, Clouds clouds, long dt, Sys sys, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "CurrentWeatherData{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", wind=" + wind +
                ", rain=" + rain +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }



    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }



}
