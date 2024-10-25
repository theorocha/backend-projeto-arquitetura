package com.arq.back.exceptions.servicoprestado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ServicoPrestadoAssociadoException extends RuntimeException {
    public ServicoPrestadoAssociadoException(String message) {
        super(message);
    }
}
