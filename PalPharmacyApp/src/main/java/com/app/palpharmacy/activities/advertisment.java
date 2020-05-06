package com.app.palpharmacy.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.app.palpharmacy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class advertisment extends Fragment {
    String urlpromo = "http://www.palpharmacy.com/index.php/getPharmacies";
    View v;
    private RecyclerView myrecyclervieww;
    private List<pharm> lstpharm;
    List<pharm> mData2;

    fragmentadapter setUprecyclerview;
    RecyclerView.LayoutManager layoutManager;
    private RequestQueue requestQueue2;
    private JsonArrayRequest request2;
    BufferedInputStream is;
    String line = null;
    String result = null;
    String[] name;
    String[] email;
    String[] imagepath;

    public advertisment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.advertisment, container, false);
        myrecyclervieww = (RecyclerView) v.findViewById(R.id.recyclerf);
        fragmentadapter recycleradapter = new fragmentadapter(getContext(), lstpharm);
        myrecyclervieww.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclervieww.setAdapter(recycleradapter);
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstpharm = new ArrayList<>();
        jsonrequest();

    }

    private void jsonrequest() {

        request2 = new JsonArrayRequest(urlpromo, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);
                        pharm pharma = new pharm();
                        pharma.setEndtime(jsonObject.getString("end_time"));
                        pharma.setPharname(jsonObject.getString("pharmacy_name"));
                        pharma.setTitle(jsonObject.getString("title"));
                        pharma.setImage(jsonObject.getInt("img_url"));
                        lstpharm.add(pharma);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                //setUprecyclerview(lstpharm);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
//
//         requestQueue2 = Volley.newRequestQueue(advertisment.this);
//          requestQueue2.add(request2);

    }

    private void collectData() {
//Connection
        try {

            URL url = new URL(urlpromo);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //content
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

//
//        try{
//            JSONArray ja=new JSONArray(result);
//            JSONObject jo=null;
//            name=new String[ja.length()];
//            email=new String[ja.length()];
//            imagepath=new String[ja.length()];
//
//            for(int i=0;i<=ja.length();i++){
//                jo=ja.getJSONObject(i);
//                name[i]=jo.getString("city");
//                email[i]=jo.getString("phone_number");
//                imagepath[i]=jo.getString("image_url");
//            }
//        }
//        catch (Exception ex)
//        {
//
//            ex.printStackTrace();
//        }
//
//
//    }


    }
}
