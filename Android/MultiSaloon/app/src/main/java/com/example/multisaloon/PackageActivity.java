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
import com.example.multisaloon.Adapter.PackageListAdapter;
import com.example.multisaloon.ModelClass.PackageModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PackageActivity extends AppCompatActivity {


    RecyclerView packageRV;
    ArrayList<PackageModelClass> list;
    GlobalPreference globalPreference;
    // ImageView backIV;
    private String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();

        // backIV=findViewById(R.id.PbackImageView);

        packageRV=findViewById(R.id.packageRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        packageRV.setLayoutManager(layoutManager);


        getpackage();
    }


    private void getpackage() {

        list = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://"+ ip +"/Multi_Saloon/api/package.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Log.d(TAG, "onResponse: "+response);

                if (response.equals("failed")){
                    Toast.makeText(PackageActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                }
                else{
                    try{
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i=0; i< jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String image = object.getString("image");
                            String offer = object.getString("offer");
                            String package_name = object.getString("package_name");
                            String rate = object.getString("rate");
                            String places = object.getString("places");
                            String description = object.getString("description");


                            list.add(new PackageModelClass(id,image,offer,package_name,rate,places,description));

                        }

                        PackageListAdapter adapter = new PackageListAdapter(list,PackageActivity.this);
                        packageRV.setAdapter(adapter);

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