package com.example.franck.first_map_application.weather.forecast.objectData.list.Sys;

/**
 * Created by Franck on 07/04/2017.
 */

public class Sys {
    private String pod ;

    public Sys(String pod) {
        this.pod = pod;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "pod='" + pod + '\'' +
                '}';
    }
}
