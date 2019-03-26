package com.vitaly_kuznetsov.onetwotriptestapplication.data.exception;

public class RestApiException extends Exception {

    private static final String ERROR_MSG = "Could not get response for your request. Please, try again later.";

    public RestApiException() {
        super(ERROR_MSG);
    }

}
