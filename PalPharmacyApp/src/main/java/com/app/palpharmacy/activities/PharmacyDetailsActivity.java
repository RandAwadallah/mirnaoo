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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.palpharmacy.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

public class PharmacyDetailsActivity extends AppCompatActivity {
    private static final int Request_Call=1;
    private TextView calltext;
    private Button callbutton;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

calltext= findViewById(R.id.aa_phone_number);
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

        // String name = getIntent().getExtras().getString("anime_name");
        //String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("aa_phone_number");
        String category = getIntent().getExtras().getString("anime_name");
        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode");
        //   String rating = getIntent().getExtras().getString("anime_rating");
        // String image_url = getIntent().getExtras().getString("anime_img");
        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String city = getIntent().getExtras().getString("anime_city");
        String image_url = getIntent().getExtras().getString("anime_img");


        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);
//
//        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_studio = findViewById(R.id.aa_vaction);
        TextView tv_categorie = findViewById(R.id.aa_categorie);
//        TextView tv_description = findViewById(R.id.aa_description);
//        TextView tv_rating = findViewById(R.id.aa_rating);
//        ImageView img = findViewById(R.id.aa_thumbnail);
        TextView tv_name = findViewById(R.id.aa_anime_name);
        // TextView tv_city = findViewById(R.id.city);
        TextView tv_description = findViewById(R.id.aa_city);
        ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        //  tv_name.setText(name);
        tv_categorie.setText(category);
        // tv_description.setText(description);
        // tv_rating.setText(rating);
        tv_studio.setText(studio);
        tv_name.setText(name);
//        tv_city.setText(city);
        tv_description.setText(description);

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

}



