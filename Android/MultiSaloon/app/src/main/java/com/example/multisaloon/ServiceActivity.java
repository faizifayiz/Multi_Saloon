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
import com.example.multisaloon.Adapter.SaloonListAdapter;
import com.example.multisaloon.Adapter.ServicesAdapter;
import com.example.multisaloon.ModelClass.SaloonModelclass;
import com.example.multisaloon.ModelClass.ServicesModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {

    RecyclerView serviceRV;
    ArrayList<ServicesModelClass> list;
    GlobalPreference globalPreference;
    // ImageView backIV;
    private String ip;
    private String sid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();

        sid = getIntent().getStringExtra("id");

        // backIV=findViewById(R.id.PbackImageView);

        serviceRV=findViewById(R.id.serviceRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        serviceRV.setLayoutManager(layoutManager);

        Toast.makeText(this, ""+sid, Toast.LENGTH_SHORT).show();


        getservice();
    }


    private void getservice() {

        list = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://"+ ip +"/Multi_Saloon/api/service.php?sid="+sid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Log.d(TAG, "onResponse: "+response);

                if (response.equals("failed")){
                    Toast.makeText(ServiceActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                }
                else{
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i=0; i< jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String sid = object.getString("shop_id");
                            String service = object.getString("service_type");
                            String time = object.getString("time");
                            String price = object.getString("price");
                            String gender = object.getString("gender");





                            list.add(new ServicesModelClass(id,sid,service,time,price,gender));

                            Toast.makeText(ServiceActivity.this, ""+sid, Toast.LENGTH_SHORT).show();

                        }

                        ServicesAdapter adapter = new ServicesAdapter(list,ServiceActivity.this);
                        serviceRV.setAdapter(adapter);

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
}