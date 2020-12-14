package com.example.tutth;

public class Fruit {
    private String name;
    private String brith;
    private int imageId;
    public Fruit(String name,String brith,int imageId){
        this.name=name;
        this.brith=brith;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public String getBrith(){
        return  brith;
    }
    public int getImageId(){
        return imageId;
    }
}
