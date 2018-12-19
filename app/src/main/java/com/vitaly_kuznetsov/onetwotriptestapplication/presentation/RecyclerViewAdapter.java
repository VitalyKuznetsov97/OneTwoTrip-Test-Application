package com.vitaly_kuznetsov.onetwotriptestapplication.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<ItemPreview> dataSet;
    private int layout;

    RecyclerViewAdapter(ArrayList<ItemPreview> dataSet, int layout) {
        this.dataSet = dataSet;
        this.layout = layout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        return new ItemPreviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
