package com.upwork.test.exception;

import com.upwork.test.model.ExceptionType;

/**
 * Created by kendy on 07/02/17.
 */
public class NetworkInitializationException extends NetworkException {

    public NetworkInitializationException(){
        this.type = ExceptionType.INVALID_NETWORK_INIZIALITATION;
    }
}
