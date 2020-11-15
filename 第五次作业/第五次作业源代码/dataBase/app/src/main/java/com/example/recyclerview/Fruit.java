package com.example.recyclerview;


import org.litepal.crud.LitePalSupport;

import java.util.UUID;

public class Fruit extends LitePalSupport {
    private long id;

    private String name;

    private int imageId;

    public Fruit(String name, int imageId) {

        this.name = name;
        this.imageId = imageId;
    }
    public Fruit(){
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}
