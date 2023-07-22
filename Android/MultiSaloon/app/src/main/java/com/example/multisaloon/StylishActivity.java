package com.example.multisaloon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.multisaloon.Adapter.StylistsAdapter;
import com.example.multisaloon.ModelClass.StylistsModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StylishActivity extends AppCompatActivity {

    private String TAG = "StylistsActivity";

    RecyclerView stylistsRV;
    ArrayList<StylistsModelClass> list;
    GlobalPreference globalPreference;
    private String ip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylish);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();

        stylistsRV=findViewById(R.id.stylistsRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        stylistsRV.setLayoutManager(layoutManager);


        getstylists();

    }

    private void getstylists() {

        list = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://"+ ip +"/Multi_Saloon/api/stylists.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Log.d(TAG, "onResponse: "+response);

                if (response.equals("failed")){
                    Toast.makeText(StylishActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                }
                else{
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i=0; i< jsonArray.length();i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String name = object.getString("name");
                            String specialization = object.getString("specialization");
                            String shop = object.getString("shop_name");
                           String destination = object.getString("place");

                            list.add(new StylistsModelClass(id,name,specialization,shop,destination));

                            //Toast.makeText(ViewDoctorsActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                        }

                        StylistsAdapter adapter = new StylistsAdapter(list,StylishActivity.this);
                        stylistsRV.setAdapter(adapter);

                    } catch(JSONException e){
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.d(TAG, "onErrorResponse: "+error);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        }
}