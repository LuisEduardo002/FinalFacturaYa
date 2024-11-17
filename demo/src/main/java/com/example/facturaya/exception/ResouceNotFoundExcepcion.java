package com.example.facturaya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResouceNotFoundExcepcion extends RuntimeException {

    public ResouceNotFoundExcepcion(String message) {
    super(message);
    }
}
