package com.example.multisaloon.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.multisaloon.ModelClass.StylistsModelClass;
import com.example.multisaloon.R;

import java.util.ArrayList;

public class StylistsAdapter extends RecyclerView.Adapter<StylistsAdapter.MyViewHolder>{

    ArrayList<StylistsModelClass> StylistsList;
    Context context;
    String ip = "";
    String id = "";
    SharedPreferences sharedPreferences;
    private static final String TAG = "StylistsAdapter";
    public static final String IPADDRESS = "stylists";

    public StylistsAdapter(ArrayList<StylistsModelClass> stylistlist, Context context) {
        this.StylistsList = stylistlist;
        this.context = context;

        sharedPreferences = context.getSharedPreferences(IPADDRESS, Context.MODE_PRIVATE);
        if (sharedPreferences.contains("ip")) {
            ip = sharedPreferences.getString("ip", "");
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_stylists, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StylistsModelClass complaint = StylistsList.get(position);
//        Log.d(TAG, "onBindViewHolder: "+"http://"+ip+"/safety/"+);
//        if (complaint.getImage().equals("")) {
//            holder.iv.setVisibility(View.GONE);
//        } else
//            Glide.with(context).load("http://" + ip + "/human_security/" + complaint.getImage()).into(holder.iv);
        holder.nameTV.setText(complaint.getName());
        holder.SpecializationTV.setText(complaint.getSpecialization());
        holder.saloonTV.setText(complaint.getShop_name());
        holder.placeTV.setText(complaint.getDestination());

    }

    @Override
    public int getItemCount () {
        return StylistsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV;
        TextView SpecializationTV;
        TextView saloonTV;
        TextView placeTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.stylistnameTV);
            SpecializationTV = itemView.findViewById(R.id.specializationTV);
            saloonTV = itemView.findViewById(R.id.shopnameTV);
            placeTV = itemView.findViewById(R.id.destinationTV);

        }

    }
}
