package com.betinnapp.educationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidTokenException extends Exception {

    public InvalidTokenException(){
        super("INVALID_TOKEN");
    }
}
