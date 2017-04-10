package com.example.franck.first_map_application;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.model.Marker;

/**
 * Created by Franck on 07/04/2017.
 */

public class weatherDialog  extends DialogFragment {

    Marker marker = null ;
    Location location = null ;

    public weatherDialog (Marker marker , Location location) {
        this.marker = marker ;
        this.location = location ;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
