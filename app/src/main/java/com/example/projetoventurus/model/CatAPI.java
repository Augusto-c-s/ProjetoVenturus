package com.example.projetoventurus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatAPI {

    @SerializedName("data")
    @Expose
    private List<ItemDataCat> data = null;

    public List<ItemDataCat> getData() {
        return data;
    }


}