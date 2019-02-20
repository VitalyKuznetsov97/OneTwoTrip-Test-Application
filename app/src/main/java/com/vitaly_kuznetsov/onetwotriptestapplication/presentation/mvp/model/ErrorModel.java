package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model;

/**
 * Class that represents an errorMessage in the presentation layer.
 */
public class ErrorModel implements IModel{

    private String errorMessage;

    public String getErrorMessage() { return errorMessage; }

    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
