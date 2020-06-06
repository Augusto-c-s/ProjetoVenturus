package com.example.projetoventurus.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final String URL= "https://api.imgur.com/3/gallery/";
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public APIService getExampleApiService() {
        return this.retrofit.create(APIService.class);
    }
}
