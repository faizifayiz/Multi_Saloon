package com.example.multisaloon.ModelClass;

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

import com.example.multisaloon.Adapter.PackageListAdapter;
import com.example.multisaloon.GlobalPreference;
import com.example.multisaloon.R;

import java.util.ArrayList;

public class PackageModelClass {

    String id;
    String image,offer,packagename,rate,places,description;

    public PackageModelClass(String id,String image,String offer,String packagename,String rate, String places, String description){
        this.id = id;
        this.image = image;
        this.offer = offer;
        this.packagename = packagename;
        this.rate = rate;
        this.places = places;
        this.description = description;
    }

    public String getId(){
        return id;
    }

    public String getImage(){
        return image;
    }

    public String getOffer(){
        return offer;
    }

    public String getPackagename(){
        return packagename;
    }

    public String getRate(){
        return rate;
    }

    public String getPlaces(){
        return places;
    }

    public String getDescription(){
        return description;
    }
}
