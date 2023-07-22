package com.example.multisaloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RatingActivity extends AppCompatActivity {

    RatingBar mRatingBar;
    TextView mRatingScale;
    Button submitBT,getrecommendBT;

    GlobalPreference globalPreference;
    private String ip,uid;

    private String sid;
    private String shop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();
        uid = globalPreference.getID();

        sid = getIntent().getStringExtra("id");
        shop_name = getIntent().getStringExtra("shop");

        mRatingBar = findViewById(R.id.ratingBar);
        mRatingScale = findViewById(R.id.tvRatingScale);
        submitBT =  findViewById(R.id.btnSubmit);
        getrecommendBT=findViewById(R.id.getrecommendation);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Very bad");
                        break;
                    case 2:
                        mRatingScale.setText("Need some improvement");
                        break;
                    case 3:
                        mRatingScale.setText("Good");
                        break;
                    case 4:
                        mRatingScale.setText("Great");
                        break;
                    case 5:
                        mRatingScale.setText("Awesome. I love it");
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });

        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(RatingActivity.this, ""+sid, Toast.LENGTH_SHORT).show();

                sendRating();

                getrecommendBT.setVisibility(View.VISIBLE);
                submitBT.setVisibility(View.INVISIBLE);
            }
        });

        getrecommendBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(RatingActivity.this, ""+shop_name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RatingActivity.this,WebActivity.class);
                intent.putExtra("id",sid);
                intent.putExtra("shop",shop_name);
                startActivity(intent);

            }
        });


    }

    private void sendRating() {
        final String ratingScale = String.valueOf(mRatingBar.getRating());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://" + ip + "/Multi_Saloon/api/rating.php?sid="+sid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {

                    Toast.makeText(RatingActivity.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RatingActivity.this, "hy" + response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RatingActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                params.put("uid",uid);
                params.put("sid",sid);
                params.put("rating",ratingScale);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(RatingActivity.this);
        requestQueue.add(stringRequest);
    }
}