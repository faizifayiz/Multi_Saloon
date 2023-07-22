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
import com.example.multisaloon.Adapter.ViewSaloonAdapter;
import com.example.multisaloon.ModelClass.SaloonModelclass;
import com.example.multisaloon.ModelClass.ViewSaloonModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

 public class ViewSaloonActivity extends AppCompatActivity {

     RecyclerView viewsaloonRV;
     ArrayList<ViewSaloonModelClass> list;
     GlobalPreference globalPreference;
     // ImageView backIV;
     private String ip;
     private String sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saloon);


        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();

        sid = getIntent().getStringExtra("id");

        viewsaloonRV=findViewById(R.id.viewsaloonRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        viewsaloonRV.setLayoutManager(layoutManager);


        getsaloon();
    }


     private void getsaloon() {

         list = new ArrayList<>();

         StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://"+ ip +"/Multi_Saloon/api/saloon.php?sid="+sid, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {

                 //Log.d(TAG, "onResponse: "+response);

                 if (response.equals("failed")){
                     Toast.makeText(ViewSaloonActivity.this, ""+response, Toast.LENGTH_SHORT).show();

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


                             list.add(new ViewSaloonModelClass(id,image,name,place,phone));
                         }

                         ViewSaloonAdapter adapter = new ViewSaloonAdapter(list,ViewSaloonActivity.this);
                         viewsaloonRV.setAdapter(adapter);

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