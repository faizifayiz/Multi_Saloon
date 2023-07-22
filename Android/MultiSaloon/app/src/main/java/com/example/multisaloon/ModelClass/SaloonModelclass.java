package com.example.multisaloon.ModelClass;

public class SaloonModelclass {

    String id;
    String image,name,place,phone;

    public SaloonModelclass(String id,String image,String name,String place,String phone){
        this.id = id;
        this.image = image;
        this.name = name;
        this.place = place;
        this.phone = phone;

    }

    public String getId(){
        return id;
    }

    public String getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public String getPlace(){
        return place;
    }

    public String getPhone(){
        return phone;
    }

}

