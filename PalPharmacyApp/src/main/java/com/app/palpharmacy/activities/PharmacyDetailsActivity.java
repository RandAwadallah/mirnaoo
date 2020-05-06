package com.app.palpharmacy.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.palpharmacy.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PharmacyDetailsActivity extends AppCompatActivity {
    private static final int Request_Call=1;
    private TextView calltext;
    private String lng;
    private String ltd;
    private Button callbutton;
    private Button mapbutton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);


        mapbutton=findViewById(R.id.buttonmap);
mapbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        openactivity();
    }
});
calltext= findViewById(R.id.phone_number);
callbutton=findViewById(R.id.phonebtn);
callbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        CallButton();
    }
});
        // hide the default actionbar
        getSupportActionBar().hide();

        // Recieve data


        String phonenumber = getIntent().getExtras().getString("phone_number");
        String vacation = getIntent().getExtras().getString("vacation");
        String openinng = getIntent().getExtras().getString("opening_time");
        String region = getIntent().getExtras().getString("region_name");
         String closing = getIntent().getExtras().getString("closing_time");
        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String city = getIntent().getExtras().getString("anime_city");
        String image_url = getIntent().getExtras().getString("anime_img");
        ltd = getIntent().getExtras().getString("latitude");
        lng = getIntent().getExtras().getString("longitude");
String insurance=getIntent().getExtras().getString("insurance");



        // ini views


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_number = findViewById(R.id.phone_number);
      TextView tv_vacation = findViewById(R.id.vaction);
//        TextView tv_description = findViewById(R.id.aa_description);
       TextView tv_region = findViewById(R.id.region);
        TextView tv_opening = findViewById(R.id.opening);
//        ImageView img = findViewById(R.id.aa_thumbnail);
        TextView tv_closing = findViewById(R.id.closing);
        TextView tv_description = findViewById(R.id.city);
        ImageView img = findViewById(R.id.aa_thumbnail);
        TextView tv_insurance = findViewById(R.id.insurance);

        // setting values to each view

        //  tv_name.setText(name);
       tv_vacation.setText(vacation);
        tv_description.setText(description);
         tv_region.setText(region);
        tv_number.setText(phonenumber);
        tv_opening.setText(openinng);
        tv_closing.setText(closing);
        tv_description.setText(description);
        tv_insurance.setText(insurance);

        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }
    private void CallButton(){
    String number = calltext.getText().toString();
    if(number.trim().length()>0){
        if(ContextCompat.checkSelfPermission(PharmacyDetailsActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PharmacyDetailsActivity.this,new String[]{Manifest.permission.CALL_PHONE},Request_Call);
        }
        else {
            String dial ="tel:"+number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==Request_Call){
            if(grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                CallButton();
            }else{
                Toast.makeText(this,"permission DENIED",Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void openactivity(){
        Intent intent = new Intent(this,map.class);
        intent.putExtra("longitude",lng);
        intent.putExtra("latitude",ltd);
        startActivity(intent);
    }

}



