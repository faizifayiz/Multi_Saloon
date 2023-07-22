package com.example.multisaloon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multisaloon.AppoinmentsActivity;
import com.example.multisaloon.GlobalPreference;
import com.example.multisaloon.ModelClass.ServicesModelClass;
import com.example.multisaloon.R;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder>{

    ArrayList<ServicesModelClass> list;
    Context context;
    private GlobalPreference globalPreference;
    String ip;

    public ServicesAdapter(ArrayList<ServicesModelClass> list, Context context) {
        this.list = list;
        this.context = context;

        globalPreference = new GlobalPreference(context);
        ip = globalPreference.getIp();

    }

        @NonNull
        @Override
        public ServicesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_services, parent, false);
            return new ServicesAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ServicesAdapter.MyViewHolder holder, int position) {
            ServicesModelClass servicelist = list.get(position);

            holder.serviceTV.setText(servicelist.getService());
            holder.timeTV.setText(servicelist.getTime());
            holder.priceTV.setText(servicelist.getPrice());
            holder.genderTV.setText(servicelist.getGender());

            holder.viewCV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AppoinmentsActivity.class);
                    intent.putExtra("service",servicelist.getService());
                    intent.putExtra("price",servicelist.getPrice());
                    intent.putExtra("id",servicelist.getId());
                    intent.putExtra("shop_id",servicelist.getShop_id());
                    context.startActivity(intent);

                   Toast.makeText(context, ""+servicelist.getShop_id(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView serviceTV, timeTV,priceTV,genderTV;
            CardView viewCV;

            public MyViewHolder(@NonNull View itemview) {
                super(itemview);

                serviceTV = itemview.findViewById(R.id.typeTV);
                timeTV= itemview.findViewById(R.id.timeTV);
                priceTV = itemview.findViewById(R.id.priceTV);
                genderTV = itemview.findViewById(R.id.genderTV);


                viewCV=itemview.findViewById(R.id.serviceCardView);
            }
        }
}
