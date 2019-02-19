package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<ItemPreview> dataSet;
    private int layout;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(ArrayList<ItemPreview> dataSet, int layout) {
        this.dataSet = dataSet;
        this.layout = layout;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == 0)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_error, parent, false);
        else
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
