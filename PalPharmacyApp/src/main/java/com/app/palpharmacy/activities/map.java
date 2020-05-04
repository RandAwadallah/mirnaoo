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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
       // String longitude = getIntent().getExtras().getString("longitude");
      //  String latitude = getIntent().getExtras().getString("latitude");
      //  TextView tv_Long = findViewById(R.id.mapAPI);
      //  TextView tv_Lat = findViewById(R.id.mapAPI);
     //   tv_Long.setText(longitude);
      //  tv_Lat.setText(latitude);
     //   getSupportActionBar().hide();
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng BethlehemUniversity  = new LatLng(31.952162, 35.233154);
        mapAPI.addMarker(new MarkerOptions().position(BethlehemUniversity).title("BethlehemUniversity"));
        mapAPI.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(BethlehemUniversity));
       // mapAPI.animateCamera(CameraUpdateFactory.newLatLngZoom(BethlehemUniversity,18),10,null);

    }
}
