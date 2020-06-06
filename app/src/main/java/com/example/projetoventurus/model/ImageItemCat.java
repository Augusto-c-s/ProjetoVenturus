package com.example.projetoventurus.model;

import com.google.gson.annotations.SerializedName;

public class ImageItemCat {

    @SerializedName("link")
    private String link;
    @SerializedName("type")
    private String type;

    public ImageItemCat() {

    }

    public ImageItemCat(String link, String type) {
        this.link = link;
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public String getType() {
        return type;
    }
}

