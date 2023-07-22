package com.example.multisaloon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AppoinmentsActivity extends AppCompatActivity {

      TextView typeTV;
    TextView amountTV;
    TextView dateTV;
    LinearLayout calenderLL;
    EditText timeET;
    Button bookBT;


    private GlobalPreference globalPreference;
    private String ip,uid;
    private String sid;
    private String shop_id;
    private String appointmentDate;
    String service,price;

    private ImageView BackImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinments);

        globalPreference = new GlobalPreference(this);
        ip = globalPreference.getIp();
        uid = globalPreference.getID();

        sid = getIntent().getStringExtra("id");

        shop_id = getIntent().getStringExtra("shop_id");


        TextView title = findViewById(R.id.appBarTitle);
        title.setText("Appointment Booking");

        BackImageButton = (ImageView) findViewById(R.id.BackImageButton);
        BackImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppoinmentsActivity.this,ServiceActivity.class);
                startActivity(intent);
            }
        });

        typeTV=findViewById(R.id.typeTextView);
        amountTV=findViewById(R.id.amountTextView);
        timeET=findViewById(R.id.timeview);
        dateTV=findViewById(R.id.DateTextView);
        calenderLL=findViewById(R.id.calenderLL);
        bookBT=findViewById(R.id.bookBT);



        service= getIntent().getStringExtra("service");
        price= getIntent().getStringExtra("price");


        typeTV.setText(service);
        amountTV.setText(price);



        calenderLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AppoinmentsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                appointmentDate = dateTV.getText().toString();

                            }
                        },

                        year, month, day);

                datePickerDialog.show();
            }
        });

            bookBT.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

         //  Toast.makeText(AppoinmentsActivity.this, ""+sid, Toast.LENGTH_SHORT).show();

            bookappointment();
        }
    });


    }

    private void bookappointment() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://" + ip + "/Multi_Saloon/api/appoinment.php?shop_id="+shop_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {
                    Intent intent = new Intent(AppoinmentsActivity.this, HomeActivity.class);
                    startActivity(intent);

                    Toast.makeText(AppoinmentsActivity.this, "Successfully Booked"+shop_id, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AppoinmentsActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AppoinmentsActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
    }){
            @Nullable
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("shop_id",shop_id);
                params.put("service",typeTV.getText().toString());
                params.put("amount",amountTV.getText().toString());
                params.put("time",timeET.getText().toString());
                params.put("appointmentDate",appointmentDate);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(AppoinmentsActivity.this);
        requestQueue.add(stringRequest);

    }
}