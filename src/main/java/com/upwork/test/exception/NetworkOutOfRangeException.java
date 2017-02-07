package com.upwork.test.exception;

import com.upwork.test.model.ExceptionType;

/**
 * Created by kendy on 07/02/17.
 */
public class NetworkOutOfRangeException extends NetworkException {

    public NetworkOutOfRangeException(){
        this.type = ExceptionType.OUT_OF_RANGE;
    }
}
