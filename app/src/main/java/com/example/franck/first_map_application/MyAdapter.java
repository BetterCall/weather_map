package com.example.franck.first_map_application;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franck.first_map_application.utils.Utils;
import com.example.franck.first_map_application.weather.forecast.ForecastWeatherData;
import com.example.franck.first_map_application.weather.forecast.objectData.list.List;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import static com.example.franck.first_map_application.utils.Utils.FormatToResource;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ForecastWeatherData data = null ;
    private ForecastWeatherActivity  activity ;

    public MyAdapter( ForecastWeatherActivity activity) {
        this.activity = activity ;
        MyAdapter.MyViewHolder.activity = activity ;
    }

    public void onArticlesReceived(ForecastWeatherData pData, boolean hasMore) {

        int length = pData.getList().length  ;
        List[] tempList = new List[(int) (length/8) +1];
        int j = 0 ; 

        for(int i = 0 ; i < length ; i++) {
            if ( (i % 8) == 1 ){
                tempList[j] = pData.getList()[i] ; 
                j++ ; 
            }
        }
        pData.setList(tempList);
        this.data = pData ;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data != null ? data.getList().length : 0  ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyclerviews, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(data.getList()[position]);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private static ForecastWeatherActivity activity ;

        private final TextView locationTextView;
        private final TextView mainTextView;
        private final TextView descriptionTextView;
        private final TextView tempTextView;
        private final TextView humidityTextView;
        private final TextView tempMinTextView;
        private final TextView tempMaxTextView;

        public MyViewHolder(View view) {
            super(view);
            locationTextView = (TextView) view.findViewById(R.id.location_field) ;
            mainTextView = (TextView) view.findViewById(R.id.main_field) ;
            descriptionTextView = (TextView) view.findViewById(R.id.description_field) ;
            tempTextView = (TextView) view.findViewById(R.id.temp_field) ;
            humidityTextView = (TextView) view.findViewById(R.id.humidity_field) ;
            tempMinTextView = (TextView) view.findViewById(R.id.temp_min_field) ;
            tempMaxTextView = (TextView) view.findViewById(R.id.temp_max_field) ;
        }

        public void bind(List article) {

            int temp = Utils.KelvinToCelsius(article.getMain().getTemp()) ;
            int temp_min = Utils.KelvinToCelsius(article.getMain().getTemp_min()) ;
            int temp_max = Utils.KelvinToCelsius(article.getMain().getTemp_max()) ;

            // Bind value to textView
            locationTextView.setText(article.getDt_txt());
            tempTextView.setText(temp+"°");
            humidityTextView.setText(""+article.getMain().getHumidity());
            tempMinTextView.setText(""+temp_min );//temp_min );
            tempMaxTextView.setText(""+ temp_max);

            try {
                // Exemple of multi language
                mainTextView.setText(
                        getStringResourceByName(
                                FormatToResource( // icon format by api => 01D converted in D01 => android format resource
                                        article
                                                .getWeather().get(0).getIcon()
                                )
                        )
                ) ;


            } catch (Exception e) {  // string not found
                e.getStackTrace() ;
            }


            descriptionTextView.setText(article.getWeather().get(0).getDescription() );

        }

        private String getStringResourceByName(String aString) {
            String packageName = activity.getPackageName();
            int resId = activity.getResources().getIdentifier(aString, "string", packageName);
            return activity.getString(resId);
        }

        public String getLocalityName( LatLng pos ) {
            Geocoder gcd = new Geocoder(activity, Locale.getDefault());
            java.util.List<Address> addresses = null;
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


}