package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller;

import android.content.Context;

import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

import java.util.ArrayList;

/**
 * Interface that allows Activities in this application to execute basic ui-commands,
 * without binding them with a specific data representing model. For example you could replace
 * RecyclerView with CardView, some custom View, etc.
 */
public interface IShowDataController {

    /**
     * Method that shows a dataSet in a layoutModel.
     */
    void showData(ArrayList<IModel> data);

    /**
     * Methods that show a Loading Process.
     */
    void showLoading(Context context);

    void hideLoading();

    /**
     * Method that shows an Error Message.
     */
    void showError(ErrorModel error);
}