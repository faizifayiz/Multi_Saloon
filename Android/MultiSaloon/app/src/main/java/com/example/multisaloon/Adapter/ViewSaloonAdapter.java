package com.example.multisaloon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.multisaloon.GlobalPreference;
import com.example.multisaloon.ModelClass.ViewSaloonModelClass;
import com.example.multisaloon.R;
import com.example.multisaloon.ServiceActivity;

import java.util.ArrayList;

public class ViewSaloonAdapter extends RecyclerView.Adapter<ViewSaloonAdapter.MyViewHolder>{

    ArrayList<ViewSaloonModelClass> list;
    Context context;
    private GlobalPreference globalPreference;
    String ip;

    public ViewSaloonAdapter(ArrayList<ViewSaloonModelClass> list, Context context) {
        this.list = list;
        this.context = context;

        globalPreference = new GlobalPreference(context);
        ip = globalPreference.getIp();

    }

    @NonNull
    @Override
    public ViewSaloonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_viewsaloon, parent, false);
        return new ViewSaloonAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewSaloonAdapter.MyViewHolder holder, int position) {
        ViewSaloonModelClass saloonlist = list.get(position);

        holder.nameTV.setText(saloonlist.getName());
        holder.placesTV.setText(saloonlist.getPlace());
        holder.phoneTV.setText(saloonlist.getPhone());

        Glide.with(context).load("http://"+ ip +"/Multi_Saloon/saloon/uploads/"+saloonlist.getImage()).into(holder.imageIV);

        holder.viewCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ServiceActivity.class);
                intent.putExtra("id",saloonlist.getId());
                context.startActivity(intent);

                Toast.makeText(context, ""+saloonlist.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, placesTV, phoneTV;
        ImageView imageIV;
        CardView viewCV;

        public MyViewHolder(@NonNull View itemview) {
            super(itemview);

            imageIV = itemview.findViewById(R.id.VsaloonImageIV);
            nameTV = itemview.findViewById(R.id.VnameTV);
            phoneTV = itemview.findViewById(R.id.VphoneTV);
            placesTV = itemview.findViewById(R.id.VplacesTV);


            viewCV = itemview.findViewById(R.id.sViewCardView);
        }
    }
}
