package com.example.projetoventurus.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoventurus.R;
import com.example.projetoventurus.model.ImageItemCat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ModelViewHolder> {

    private ArrayList<ImageItemCat> listImageItemCat;
    private OnItemClickListener onitemclicklistener;
    private Context context;


    public RecyclerViewAdapter(ArrayList<ImageItemCat> list) {
        listImageItemCat = list;
    }


    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list, parent, false);
        ModelViewHolder modelViewHolder = new ModelViewHolder(v, onitemclicklistener);
        context = parent.getContext();
        return modelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        ImageItemCat currentItem = listImageItemCat.get(position);
        if (currentItem.getType().contains("image")) {
            loadPhoto(currentItem.getLink(), holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return listImageItemCat.size();
    }

    private void loadPhoto(String url, ImageView imageView) {
        Picasso.with(context).load(url).resize(300, 200).into(imageView);

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class ModelViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;


        private ModelViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.catImageView);

        }
    }
}

