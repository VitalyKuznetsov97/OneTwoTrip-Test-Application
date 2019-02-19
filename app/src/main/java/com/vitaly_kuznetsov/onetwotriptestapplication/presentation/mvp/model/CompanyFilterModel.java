package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model;

/**
 * Class that represents single companyFilter in the presentation layer.
 */

public class CompanyFilterModel {

    private final int companyId;

    public CompanyFilterModel(int companyId) { this.companyId = companyId; }

    private String companyName;
    private boolean checked;

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String hotelName) { this.companyName = hotelName; }

    public boolean isChecked() { return checked; }

    public void setChecked(boolean checked) { this.checked = checked; }

}
