package com.adritec96.apiCites.Share;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnAutorizazed extends Exception{
    public ApiUnAutorizazed(String message) {
        super(message);
    }
}
