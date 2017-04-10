package com.example.franck.first_map_application;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franck.first_map_application.tasks.CurrentWeatherTask;
import com.example.franck.first_map_application.utils.Utils;
import com.example.franck.first_map_application.weather.simple.CurrentWeatherData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.example.franck.first_map_application.utils.Utils.FormatToResource;

public class MapsActivity
        extends
            FragmentActivity
        implements
            GoogleMap.InfoWindowAdapter,
            GoogleMap.OnMarkerClickListener,
            OnMapReadyCallback,
            View.OnClickListener,
            LocationListener
{

    public GoogleMap mMap;
    private LocationManager locationManager = null;
    private LocationListener locationListener = null;
    private Location location = null;
    public static Marker myMarker = null ;

    private LatLng pos = null ;
    public static double latitude;
    public static double longitude;

    // current weather view
    public View weatherView = null ;

    // current weather field
    public TextView locationTextView ;
    public TextView tempTextView ;
    public TextView mainTextView ;
    public TextView descriptionTextView ;
    // AsyncTask get current weather
    CurrentWeatherTask currentWeatherTask = null ;
    private String weatherUrl = "api.openweathermap.org/data/2.5/forecast?" ; //lat=35&lon=139"

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putDouble("latitude", pos.latitude);
        outState.putDouble("longitude", pos.longitude);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( savedInstanceState != null ) {
            pos = new LatLng(
                    savedInstanceState
                            .getDouble("latitude") ,
                    savedInstanceState
                            .getDouble( "longitude")
            ) ;
        }


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);


        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // intialiaze the current weather view
        weatherView = getLayoutInflater().inflate(R.layout.weather_informations, null) ;
        //initialize current weather fields
        locationTextView = (TextView) weatherView.findViewById(R.id.location_field);
        tempTextView = ( TextView ) weatherView.findViewById(R.id.temp_field) ;
        mainTextView = ( TextView ) weatherView.findViewById(R.id.main_field) ;
        descriptionTextView = ( TextView ) weatherView.findViewById(R.id.description_field) ;

        Utils.initWeatherIcon();
        if (myMarker != null && myMarker.isInfoWindowShown())
            myMarker.showInfoWindow();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setInfoWindowAdapter(this);

        if (location != null) {
            pos = new LatLng(location.getLatitude() , location.getLongitude()) ;
        } else {
            pos = new LatLng(55,-55) ;
        }

        myMarker = mMap.addMarker(new MarkerOptions().position(pos));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                Gson gson = new GsonBuilder()
                        .serializeNulls()
                        .create();

                Intent intent = new Intent(getBaseContext(), ForecastWeatherActivity.class);
                intent.putExtra("coord", gson.toJson(pos) );

                // Starting the  Activity
                startActivity(intent);

            }
        });

        currentWeatherTask = new CurrentWeatherTask(
                pos ,
                myMarker
        ) ;
        currentWeatherTask.execute() ;

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng pos) {
                // TODO Auto-generated method stub

                currentWeatherTask = new CurrentWeatherTask(
                        pos ,
                        myMarker
                ) ;
                currentWeatherTask.execute() ;

            }
        });

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.equals(myMarker)) {

            return false ;
        }
        return true ;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
        //return prepareInfoView(marker);
    }

    @Override
    public View getInfoContents(Marker marker) {
        //return null;
        return prepareInfoView(marker);
    }

    private View prepareInfoView(Marker marker){

        // convert string result to currentWeatherData Object
        JsonParser parser = new JsonParser() ;
        JsonObject json = (JsonObject )parser.parse(marker.getSnippet()) ;

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        CurrentWeatherData data = (CurrentWeatherData)
                gson.fromJson(json,CurrentWeatherData.class);

        // Use resource for traduction
        Resources res = getResources();

        // get correct location
        // when the marker position return an empty string location use Geometer
        String location = "" ;
        if ( data.getName() != "" ) {
            location = Utils.CorrectLocation(data.getName() , data.getSys().getCountry(), "" );
        } else {
            location = getLocalityName(marker.getPosition()) ;
        }
        int temp = Utils.KelvinToCelsius(data.getMain().getTemp()) ;
        int temp_min = Utils.KelvinToCelsius(data.getMain().getTemp_min()) ;
        int temp_max = Utils.KelvinToCelsius(data.getMain().getTemp_max()) ;


        // Bind value to textView
        locationTextView.setText(location);
        tempTextView.setText(temp + "°");

        try {
            // Exemple of multi language
            mainTextView.setText(
                    getStringResourceByName(
                            FormatToResource( // icon format by api => 01D converted in D01 => android format resource
                                    data
                                            .getWeather().get(0).getIcon()
                            )
                    )
            ) ;


        } catch (Exception e) {  // string not found
            e.getStackTrace() ;
        }


        pos = new LatLng(
                data.getCoord().getLat() ,
                data.getCoord().getLon()
        ) ;
        descriptionTextView.setText(data.getWeather().get(0).getDescription() );

        return weatherView ;
    }


    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

    public String getLocalityName( LatLng pos ) {
        Geocoder gcd = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = gcd.getFromLocation(pos.latitude, pos.longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses.size() > 0)
            return addresses.get(0).getLocality() ;
        else
            return "La mer noire" ;
    }



}

