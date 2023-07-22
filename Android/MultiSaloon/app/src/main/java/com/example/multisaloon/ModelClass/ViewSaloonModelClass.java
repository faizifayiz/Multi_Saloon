package com.example.multisaloon.ModelClass;

public class ViewSaloonModelClass {
    String id;
    String image,name,place,phone;
    //String shop_id;

    public ViewSaloonModelClass(String id,String image,String name,String place,String phone){
        this.id = id;
        this.image = image;
        this.name = name;
        this.place = place;
        this.phone = phone;
       // this.shop_id = shop_id;

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

   // public String getShop_id(){
       //return shop_id;
    //}
}
