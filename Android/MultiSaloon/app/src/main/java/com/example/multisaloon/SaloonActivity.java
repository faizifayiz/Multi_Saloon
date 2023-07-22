package com.example.multisaloon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.multisaloon.Adapter.PackageListAdapter;
import com.example.multisaloon.Adapter.SaloonListAdapter;
import com.example.multisaloon.ModelClass.PackageModelClass;
import com.example.multisaloon.ModelClass.SaloonModelclass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SaloonActivity extends AppCompatActivity {

    private static String TAG ="SaloonActivity";

    EditText placeET;
    ImageView searchIV;

    RecyclerView saloonRV;
    ArrayList<SaloonModelclass> list;
    GlobalPreference globalPreference;
    // ImageView backIV;
    private String ip;
    private String sid;
    private String shop_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon);


        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();


        placeET = findViewById(R.id.placeET);
        searchIV = findViewById(R.id.searchIV);

        sid = getIntent().getStringExtra("id");
        shop_name=getIntent().getStringExtra("shop_name");

        // backIV=findViewById(R.id.PbackImageView);

        saloonRV=findViewById(R.id.saloonRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        saloonRV.setLayoutManager(layoutManager);


        getsaloon();

        searchIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(SaloonActivity.this, ""+placeET.getText().toString(), Toast.LENGTH_SHORT).show();
                searchSaloons();
            }
        });
    }


    private void getsaloon() {

        list = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://"+ ip +"/Multi_Saloon/api/saloon.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Log.d(TAG, "onResponse: "+response);

                if (response.equals("failed")){
                    Toast.makeText(SaloonActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                }
                else{
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i=0; i< jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String image = object.getString("image");
                            String name = object.getString("shop_name");
                            String place = object.getString("place");
                            String phone = object.getString("phone");



                            list.add(new SaloonModelclass(id,image,name,place,phone));

                        }

                        SaloonListAdapter adapter = new SaloonListAdapter(list,SaloonActivity.this);
                        saloonRV.setAdapter(adapter);

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

       /* backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PackageActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });*/


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }

    //search suppliers based on location

    private void searchSaloons() {
        list = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://" + ip + "/Multi_Saloon/api/searchSaloons.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.trim().equals("failed")){
                    Toast.makeText(SaloonActivity.this, "No Suppliers Available", Toast.LENGTH_SHORT).show();

                    saloonRV.setVisibility(View.INVISIBLE);
                }
                else {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String image = object.getString("image");
                            String name = object.getString("shop_name");
                            String place = object.getString("place");
                            String phone = object.getString("phone");

                            list.add(new SaloonModelclass(id,image,name,place,phone));
                        }

                        SaloonListAdapter adapter = new SaloonListAdapter(list,SaloonActivity.this);
                        saloonRV.setAdapter(adapter);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onResponse: "+error);
            }
        }){
            @Override
            @Nullable
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("place",placeET.getText().toString());
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(SaloonActivity.this);
        requestQueue.add(stringRequest);
    }
}
