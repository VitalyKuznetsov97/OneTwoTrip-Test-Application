package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

public interface IViewHolder<Model extends IModel> {

    void bind(Model model);
}
