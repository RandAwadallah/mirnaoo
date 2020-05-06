package com.app.palpharmacy.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.app.palpharmacy.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    private String ltd,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ltd = getIntent().getExtras().getString("latitude");
        lng = getIntent().getExtras().getString("longitude");

        if(isNullOrEmpty(ltd)){
            ltd = "32.217086";
        }
        if(isNullOrEmpty(lng)){
            lng ="35.271603";
        }

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);
    }
    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        double x = Double.parseDouble(ltd);

        double y = Double.parseDouble(lng);
        LatLng BethlehemUniversity  = new LatLng(x, y);
        mapAPI.addMarker(new MarkerOptions().position(BethlehemUniversity).title("BethlehemUniversity"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(BethlehemUniversity));
       // mapAPI.animateCamera(CameraUpdateFactory.newLatLngZoom(BethlehemUniversity,18),10,null);

    }
}
