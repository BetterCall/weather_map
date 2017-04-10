package com.example.franck.first_map_application.tasks;

import android.os.AsyncTask;
import com.example.franck.first_map_application.MyAdapter;
import com.example.franck.first_map_application.weather.forecast.ForecastWeatherData;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Franck on 07/04/2017.
 */

public class ForecastWeatherTask
        extends AsyncTask<String, Void , String>
{

    LatLng pos ;

    MyAdapter adapter = null  ;

    String apiUrl  = "api.openweathermap.org/data/2.5/forecast" ;
    String appid = "548dca5befd1c06b98de1bbee2cc836a" ;

    public ForecastWeatherTask(
            LatLng pos,
            MyAdapter adapter
    ) {
        this.pos = pos ;
        this.adapter = adapter ;
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
        // Convert the string result into Object
        JsonParser parser = new JsonParser() ;
        JsonObject json = (JsonObject )parser.parse(result) ;

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        ForecastWeatherData data = (ForecastWeatherData)
                gson.fromJson(json,ForecastWeatherData.class);
        // Send the data to the recyclerView
        adapter.onArticlesReceived(data , false);
    }
}