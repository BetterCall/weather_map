package com.example.franck.first_map_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.franck.first_map_application.tasks.ForecastWeatherTask;
import com.example.franck.first_map_application.weather.simple.CurrentWeatherData;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Franck on 08/04/2017.
 */

public class ForecastWeatherActivity
        extends
            FragmentActivity
{
    private LatLng pos ;
    private ForecastWeatherTask _task = null ;
    MyAdapter adapter = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forecast_weather);
        RecyclerView rv = ( RecyclerView ) findViewById(R.id.weather_list)  ;

        //position
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this) ;
        //Data
        rv.setAdapter(adapter);

        // intent
        Intent intent = getIntent() ;
        String coord = intent.getStringExtra("coord") ;

        JsonParser parser = new JsonParser() ;
        JsonObject json = (JsonObject )parser.parse(coord) ;

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        pos = (LatLng)
                gson.fromJson(json,LatLng.class);

        Log.i("pos" , ""+pos.latitude) ;

        _task = new ForecastWeatherTask(pos,adapter) ;
        _task.execute() ;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _task.cancel(true);
    }
}
