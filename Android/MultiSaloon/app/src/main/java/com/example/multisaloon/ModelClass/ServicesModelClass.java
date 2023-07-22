package com.example.multisaloon.ModelClass;

public class ServicesModelClass {

    String id;
    String shop_id;
    String service;
    String time;
    String price;
    String gender;

    public ServicesModelClass(String id,String shop_id,String service, String time, String price, String gender) {
        this.id = id;
        this.shop_id = shop_id;
        this.service = service;
        this.time = time;
        this.price = price;
        this.gender = gender;
    }


    public String getId() {
        return id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public String getService() {
        return service;
    }

    public String getTime() {
        return time;
    }

    public String getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }



}
