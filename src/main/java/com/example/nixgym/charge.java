package com.example.nixgym;

public class charge {
    Double Price;
    String description;
    String types;

    public Double getPrice() {
        return Price;
    }

    public String getDescription() {
        return description;
    }

    public String getTypes() {
        return types;
    }

    public charge(){

    }
    public charge(double price,String description,String types){
        this.Price = price;
        this.description = description;
        this.types = types;
    }

    public void setPrice(double Price){
        this.Price = Price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTypes(String types){
        this.types = types;
    }
}
