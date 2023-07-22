package com.example.multisaloon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.multisaloon.GlobalPreference;
import com.example.multisaloon.ModelClass.PackageModelClass;
import com.example.multisaloon.R;

import java.util.ArrayList;

public class PackageListAdapter extends RecyclerView.Adapter<PackageListAdapter.MyViewHolder>{


    ArrayList<PackageModelClass> list;
    Context context;
    private GlobalPreference globalPreference;
    String ip;

    public PackageListAdapter(ArrayList<PackageModelClass> list, Context context) {
        this.list = list;
        this.context = context;

        globalPreference = new GlobalPreference(context);
        ip = globalPreference.getIp();

    }

    @NonNull
    @Override
    public PackageListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_package, parent, false);
        return new PackageListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageListAdapter.MyViewHolder holder, int position) {
        PackageModelClass packagelist = list.get(position);

        holder.packagenameTV.setText(packagelist.getPackagename());
        holder.rateTV.setText("₹"+packagelist.getRate());
        holder.offerpriceTV.setText("₹"+packagelist.getOffer());
        holder.placesTV.setText(packagelist.getPlaces());
        holder.descriptionTV.setText(packagelist.getDescription());

        Glide.with(context).load("http://"+ ip +"/Multi_Saloon/package/uploads/"+packagelist.getImage()).into(holder.imageIV);

//        holder.viewCV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, AppointmentActivity.class);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView offerpriceTV,packagenameTV,rateTV, placesTV, descriptionTV;
        ImageView imageIV;
        //CardView viewCV;

        public MyViewHolder(@NonNull View itemview) {
            super(itemview);

            imageIV = itemview.findViewById(R.id.packageImageIV);
            offerpriceTV= itemview.findViewById(R.id.offerTV);
            packagenameTV = itemview.findViewById(R.id.packagenameTV);
            rateTV = itemview.findViewById(R.id.rateTV);
            placesTV = itemview.findViewById(R.id.placesTV);

            descriptionTV= itemview.findViewById(R.id.descTV);
           // viewCV=itemview.findViewById(R.id.ViewCardView);
        }
    }
}
