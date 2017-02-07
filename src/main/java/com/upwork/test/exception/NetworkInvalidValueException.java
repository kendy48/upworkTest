package com.upwork.test.exception;

import com.upwork.test.model.ExceptionType;

/**
 * Created by kendy on 07/02/17.
 */
public class NetworkInvalidValueException extends NetworkException {

    public NetworkInvalidValueException(){
        this.type = ExceptionType.INVALID_VALUE;
    }
}
