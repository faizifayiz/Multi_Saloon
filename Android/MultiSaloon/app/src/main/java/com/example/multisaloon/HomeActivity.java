package com.example.multisaloon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    CardView packageCV;
    CardView saloonCV;
    CardView servicesCV;
    CardView stylistsCV;
    CardView feebbackCV;
    CardView recommendCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        packageCV=findViewById(R.id.PackagesCV);
        saloonCV=findViewById(R.id.SaloonCV);
        servicesCV=findViewById(R.id.ServicesCV);
        stylistsCV=findViewById(R.id.StylistsCV);
        feebbackCV=findViewById(R.id.feedbackCV);
        recommendCV=findViewById(R.id.recommendationCV);



        packageCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,PackageActivity.class);
                startActivity(intent);
            }
        });

        stylistsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,StylishActivity.class);
                startActivity(intent);
            }
        });

        saloonCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SaloonActivity.class);
                startActivity(intent);
            }
        });

        servicesCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ViewSaloonActivity.class);
                startActivity(intent);
            }
        });

        feebbackCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,FeedbackActivity.class);
                startActivity(intent);
            }
        });

        recommendCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,WebActivity.class);
                startActivity(intent);
            }
        });
    }
}