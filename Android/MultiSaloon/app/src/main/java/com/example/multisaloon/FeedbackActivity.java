package com.example.multisaloon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class FeedbackActivity extends AppCompatActivity {

    EditText feedbackET,shopnameET;
    Button submitBT;

    private GlobalPreference globalPreference;
    private String ip,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();
        uid = globalPreference.getID();

        feedbackET = findViewById(R.id.feedbackEditText);
        shopnameET=findViewById(R.id.ShopnameET);
        submitBT = findViewById(R.id.submitFeedback);

        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
            }
        });
    }

    private void submitFeedback() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://"+ ip +"/Multi_Saloon/api/feedback.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")){
                    Toast.makeText(FeedbackActivity.this, "Thank you for sharing your valuable feedback", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(FeedbackActivity.this,""+response,Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FeedbackActivity.this,""+error,Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("uid",uid);
                params.put("feedback",feedbackET.getText().toString());
                params.put("shop_name",shopnameET.getText().toString());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(FeedbackActivity.this);
        requestQueue.add(stringRequest);
    }
}