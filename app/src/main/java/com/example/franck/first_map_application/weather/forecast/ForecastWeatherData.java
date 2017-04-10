package com.example.franck.first_map_application.weather.forecast;

import com.example.franck.first_map_application.weather.forecast.objectData.city.City;
import com.example.franck.first_map_application.weather.forecast.objectData.list.List;

import java.util.ArrayList;

/**
 * Created by Franck on 07/04/2017.
 */

public class ForecastWeatherData {

    private int cod ;
    private float message ;
    private int cnt ;

    private List[] list ;

    private City city ;
    private String country ;
    private long population ;

    public ForecastWeatherData() {

    }

    public ForecastWeatherData(int cod, float message, int cnt, List[] list, City city, String country, long population) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
        this.country = country;
        this.population = population;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List[] getList() {
        return list;
    }

    public void setList(List[] list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "ForecastWeatherData{" +
                "cod=" + cod +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }


}
