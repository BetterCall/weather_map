package com.example.franck.first_map_application.weather.forecast.objectData.list;

import com.example.franck.first_map_application.weather.forecast.objectData.list.clouds.Clouds;
import com.example.franck.first_map_application.weather.forecast.objectData.list.Sys.Sys;
import com.example.franck.first_map_application.weather.forecast.objectData.list.weather.Weather;
import com.example.franck.first_map_application.weather.forecast.objectData.list.wind.Wind;
import com.example.franck.first_map_application.weather.forecast.objectData.list.main.Main;

/**
 * Created by Franck on 07/04/2017.
 */

public class List {

    private long dt ;
    private Main main ;

    private java.util.List<Weather> weather ;
    private Clouds clouds;
    private Wind wind ;
    private Sys sys ;
    private String dt_txt ;


    public List(long dt, Main main, java.util.List<Weather> weather, Clouds clouds, Wind wind, Sys sys, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }


    @Override
    public String toString() {
        return "List{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
