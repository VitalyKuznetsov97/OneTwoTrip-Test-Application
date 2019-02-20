package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ChooseFilterModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.DestinationModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder.ChooseViewHolder;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder.DestinationViewHolder;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder.ErrorViewHolder;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder.IViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.VIEW_HOLDER_CHOOSE;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.VIEW_HOLDER_DESTINATION;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.VIEW_HOLDER_ERROR;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<IModel> data;

    public void showData(ArrayList<IModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void showError(ErrorModel errorModel){
        if (data != null && data.get(0) instanceof ErrorModel){
            data.remove(0);
        }
        else {
            data = new ArrayList<>();
            data.add(0, errorModel);
            notifyItemInserted(0);
        }
    }

    @Override
    public int getItemViewType(int position) {
        IModel model = data.get(position);
        if (model instanceof DestinationModel) return VIEW_HOLDER_DESTINATION;
        else if (model instanceof ChooseFilterModel) return VIEW_HOLDER_CHOOSE;
        else return VIEW_HOLDER_ERROR;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_HOLDER_DESTINATION) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_result, parent, false);
            return new DestinationViewHolder(view);
        }
        else if (viewType == VIEW_HOLDER_CHOOSE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_choose, parent, false);
            return new ChooseViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_error, parent, false);
            return new ErrorViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        IViewHolder viewHolder = (IViewHolder) holder;
        viewHolder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
