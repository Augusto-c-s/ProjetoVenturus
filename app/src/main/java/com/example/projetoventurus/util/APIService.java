package com.example.projetoventurus.util;


import com.example.projetoventurus.model.CatAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {

    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("search/?q=cats")
    Call<CatAPI> getPhotos();
}