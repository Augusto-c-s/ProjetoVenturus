package com.example.projetoventurus.util;

import android.app.Activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projetoventurus.R;
import com.example.projetoventurus.model.CatAPI;
import com.example.projetoventurus.model.ImageItemCat;
import com.example.projetoventurus.model.ItemDataCat;
import com.example.projetoventurus.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCat {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Activity activity;

    public RetrofitCat(MainActivity activity) {
        this.activity = activity;
    }


    public void getListOfExampleRetrofit() {


        Call<CatAPI> call = new RetrofitConfig().getExampleApiService().getPhotos();

        call.enqueue(new Callback<CatAPI>() {
            @Override
            public void onResponse(Call<CatAPI> call, Response<CatAPI> response) {
                ArrayList<ImageItemCat> imageList = new ArrayList<>();

                List<ItemDataCat> dataItems = response.body().getData();

                for (int i = 0; i < dataItems.size(); i++) {
                    final ItemDataCat dataItem = dataItems.get(i);
                    if (dataItem.getImages() != null) {
                        for (int x = 0; x < dataItems.get(i).getImages().size(); x++) {
                            imageList.add(dataItems.get(i).getImages().get(x));
                        }
                    }
                }
                buildRecycleView(imageList);
            }

            @Override
            public void onFailure(Call<CatAPI> call, Throwable t) {

            }
        });
    }

    private void buildRecycleView(ArrayList<ImageItemCat> imageList) {
        mRecyclerView = activity.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(activity, 4);
        mAdapter = new RecyclerViewAdapter(imageList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}

