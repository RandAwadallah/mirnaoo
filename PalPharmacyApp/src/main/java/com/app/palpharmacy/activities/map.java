package com.app.palpharmacy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.palpharmacy.R;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().hide();
    }
}
