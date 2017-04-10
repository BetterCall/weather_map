package com.example.franck.first_map_application.tasks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franck.first_map_application.MapsActivity;
import com.example.franck.first_map_application.R;
import com.example.franck.first_map_application.utils.Utils;
import com.example.franck.first_map_application.weather.simple.CurrentWeatherData;
import com.github.pwittchen.weathericonview.WeatherIconView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Franck on 07/04/2017.
 */

public class CurrentWeatherTask
        extends AsyncTask<String, Void , String>
{

    LatLng pos ;
    Marker marker ;

    String apiUrl  = "api.openweathermap.org/data/2.5/weather" ;
    String appid = "548dca5befd1c06b98de1bbee2cc836a" ;

    public CurrentWeatherTask(
            LatLng pos ,
            Marker marker
    ) {
        this.pos = pos ;
        this.marker = marker ;
    }

    @Override
    protected String doInBackground(String... params) {

        String result = "" ;
        URL url ;
        HttpURLConnection urlConnection = null ;

        String urlString = "http://" + apiUrl + "?lat=" + pos.latitude + "&lon=" + pos.longitude + "&appid=" +appid ;

        try {
            url = new URL( urlString
            )  ;

            // we use the OkHttp library from https://github.com/square/okhttp
            OkHttpClient client = new OkHttpClient();
            Request request =
                    new Request.Builder()
                            .url(url)
                            .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
                return result ;
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null ;

    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        //Update marker's position
        marker.setPosition(pos);
        // set data to maps activity marker
        marker.setSnippet(result);
    }



}

