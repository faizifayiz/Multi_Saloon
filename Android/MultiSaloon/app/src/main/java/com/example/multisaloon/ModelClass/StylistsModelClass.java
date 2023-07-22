package com.example.multisaloon.ModelClass;

public class StylistsModelClass {

    String id;
    String name;
    String specialization;
    String shop_name;
    String destination;

    public StylistsModelClass(String id, String name, String specialization,String shop_name,String destination) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.shop_name = shop_name;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getDestination() {return destination;
    }
}
