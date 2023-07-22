package com.example.multisaloon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class RegisterActivity extends AppCompatActivity {

    private GlobalPreference globalPreference;
    private String ip;

    EditText nameET;
    EditText emailET;
    EditText passwordET;
    EditText phoneET;
    RadioButton male,female;
    Button submitBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();

        nameET=findViewById(R.id.nameEditText);
        emailET=findViewById(R.id.emailEditText);
        passwordET=findViewById(R.id.passwordEditText);
        phoneET=findViewById(R.id.phoneEditText);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        submitBT=findViewById(R.id.registerButtonn);


        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uregister();


            }
        });
    }

    private void Uregister() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://"+ ip +"/Multi_Saloon/api/register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){

                    Toast.makeText(RegisterActivity.this, "You are Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegisterActivity.this,""+response,Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this,""+error,Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            @Nullable
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",nameET.getText().toString());
                params.put("email",emailET.getText().toString());
                params.put("password",passwordET.getText().toString());
                params.put("phone",phoneET.getText().toString());
                if (male.isChecked()) {
                    params.put("gender", "male");
                } else {
                    params.put("gender", "female");

                }
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        requestQueue.add(stringRequest);
    }
}