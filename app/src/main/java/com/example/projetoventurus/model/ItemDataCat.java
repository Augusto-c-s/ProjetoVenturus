package com.example.projetoventurus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDataCat {

    @SerializedName("images")
    @Expose
    private List<ImageItemCat> images;

    public ItemDataCat() {

    }

    public List<ImageItemCat> getImages() {
        return images;
    }
}
