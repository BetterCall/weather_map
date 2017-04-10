package com.example.franck.first_map_application.utils;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Franck on 08/04/2017.
 */

public class Utils {

    public static HashMap<Integer ,Integer> weatherIcon= new HashMap<>();

    public static void initWeatherIcon() {

        weatherIcon.put(200 , Color.DKGRAY) ;
        weatherIcon.put(201 , Color.DKGRAY) ;
        weatherIcon.put(202 , Color.DKGRAY) ;
        weatherIcon.put(210 , Color.DKGRAY) ;
        weatherIcon.put(211 , Color.DKGRAY) ;
        weatherIcon.put(212 , Color.DKGRAY) ;
        weatherIcon.put(221 , Color.DKGRAY) ;
        weatherIcon.put(230 , Color.DKGRAY) ;
        weatherIcon.put(231 , Color.DKGRAY) ;
        weatherIcon.put(232 , Color.DKGRAY) ;

        weatherIcon.put(300 , Color.LTGRAY) ;
        weatherIcon.put(301 , Color.LTGRAY) ;
        weatherIcon.put(302 , Color.LTGRAY) ;
        weatherIcon.put(310 , Color.LTGRAY) ;
        weatherIcon.put(311 , Color.LTGRAY) ;
        weatherIcon.put(312 , Color.LTGRAY) ;
        weatherIcon.put(313 , Color.LTGRAY) ;
        weatherIcon.put(314 , Color.LTGRAY) ;
        weatherIcon.put(321 , Color.LTGRAY) ;

        weatherIcon.put(500 , Color.LTGRAY) ;
        weatherIcon.put(501 , Color.LTGRAY) ;
        weatherIcon.put(502 , Color.LTGRAY) ;
        weatherIcon.put(503 , Color.LTGRAY) ;
        weatherIcon.put(504 , Color.LTGRAY) ;
        weatherIcon.put(511 , Color.WHITE) ;
        weatherIcon.put(520 , Color.LTGRAY) ;
        weatherIcon.put(521 , Color.LTGRAY) ;
        weatherIcon.put(522 , Color.LTGRAY) ;
        weatherIcon.put(531 , Color.LTGRAY) ;

        weatherIcon.put(600 , Color.WHITE) ;
        weatherIcon.put(601 , Color.WHITE) ;
        weatherIcon.put(602 , Color.WHITE) ;
        weatherIcon.put(611 , Color.WHITE) ;
        weatherIcon.put(612 , Color.WHITE) ;
        weatherIcon.put(615 , Color.WHITE) ;
        weatherIcon.put(616 , Color.WHITE) ;
        weatherIcon.put(620 , Color.WHITE) ;
        weatherIcon.put(621 , Color.WHITE) ;
        weatherIcon.put(622 , Color.WHITE) ;

        weatherIcon.put(701 , Color.YELLOW) ;
        weatherIcon.put(711 , Color.YELLOW) ;
        weatherIcon.put(721 , Color.YELLOW) ;
        weatherIcon.put(731 , Color.YELLOW) ;
        weatherIcon.put(741 , Color.YELLOW) ;
        weatherIcon.put(751 , Color.YELLOW) ;
        weatherIcon.put(761 , Color.YELLOW) ;
        weatherIcon.put(762 , Color.YELLOW) ;
        weatherIcon.put(771 , Color.YELLOW) ;
        weatherIcon.put(781 , Color.YELLOW) ;

        weatherIcon.put(800 , Color.YELLOW) ;
        weatherIcon.put(801 , Color.YELLOW) ;
        weatherIcon.put(802 , Color.YELLOW) ;
        weatherIcon.put(803 , Color.YELLOW) ;
        weatherIcon.put(804 , Color.YELLOW) ;

    }

    public static int KelvinToCelsius(double temp) {
        return (int) (temp - 273.15)  ;
    }

    public static String CorrectLocation(String city, String country , String defaultLocation ) {
        return city != "" ? city + ", " + country : defaultLocation ;
    }

    public static int getWeatherIcon(int code) {
        return weatherIcon.get(code) ;
    }

    public static String FormatToResource(String apiPath) {

        char a1 = apiPath.charAt(0) ;
        char a2 = apiPath.charAt(1) ;
        char a3 = apiPath.charAt(2) ;

        return a3+ ""+a1+""+a2  ;

    }

}
