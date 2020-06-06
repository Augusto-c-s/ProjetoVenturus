package com.example.projetoventurus.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoventurus.R;
import com.example.projetoventurus.util.RetrofitCat;

public class MainActivity extends AppCompatActivity {

    private RetrofitCat retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        retrofit = new RetrofitCat(this);
        retrofit.getListOfExampleRetrofit();
    }
}