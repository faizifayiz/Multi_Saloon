package com.example.multisaloon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.multisaloon.GlobalPreference;
import com.example.multisaloon.ModelClass.SaloonModelclass;
import com.example.multisaloon.R;
import com.example.multisaloon.RatingActivity;

import java.util.ArrayList;

public class SaloonListAdapter extends RecyclerView.Adapter<SaloonListAdapter.MyViewHolder>{


    ArrayList<SaloonModelclass> list;
    Context context;
    private GlobalPreference globalPreference;
    String ip;

    public SaloonListAdapter(ArrayList<SaloonModelclass> list, Context context) {
        this.list = list;
        this.context = context;

        globalPreference = new GlobalPreference(context);
        ip = globalPreference.getIp();

    }

    @NonNull
    @Override
    public SaloonListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_saloon, parent, false);
        return new SaloonListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaloonListAdapter.MyViewHolder holder, int position) {
        SaloonModelclass saloonlist = list.get(position);

        holder.nameTV.setText(saloonlist.getName());
        holder.placesTV.setText(saloonlist.getPlace());
        holder.phoneTV.setText(saloonlist.getPhone());


       Glide.with(context).load("http://"+ ip +"/Multi_Saloon/saloon/uploads/"+saloonlist.getImage()).into(holder.imageIV);

        holder.viewCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RatingActivity.class);
                intent.putExtra("id",saloonlist.getId());
                intent.putExtra("shop",saloonlist.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, placesTV,phoneTV;
        ImageView imageIV;
        CardView viewCV;

        public MyViewHolder(@NonNull View itemview) {
            super(itemview);

            imageIV = itemview.findViewById(R.id.saloonImageIV);
            nameTV= itemview.findViewById(R.id.SnameTV);
            phoneTV = itemview.findViewById(R.id.SphoneTV);
            placesTV = itemview.findViewById(R.id.SplacesTV);


            viewCV=itemview.findViewById(R.id.SViewCardView);
        }
    }
}
