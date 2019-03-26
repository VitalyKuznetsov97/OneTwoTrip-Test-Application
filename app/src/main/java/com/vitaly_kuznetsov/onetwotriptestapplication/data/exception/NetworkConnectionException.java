package com.vitaly_kuznetsov.onetwotriptestapplication.data.exception;

public class NetworkConnectionException extends Exception {

    private static final String ERROR_MSG = "Could not connect to internet. Please, check your connection.";

    public NetworkConnectionException() {
        super(ERROR_MSG);
    }

}
