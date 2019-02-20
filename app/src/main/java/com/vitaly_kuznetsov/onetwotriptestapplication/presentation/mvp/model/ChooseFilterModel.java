package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model;

/**
 * Class that represents single companyFilter in the presentation layer.
 */

public class ChooseFilterModel implements IModel{

    private int id;
    private String name;
    private boolean checked;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isChecked() { return checked; }

    public void setChecked(boolean checked) { this.checked = checked; }

}
