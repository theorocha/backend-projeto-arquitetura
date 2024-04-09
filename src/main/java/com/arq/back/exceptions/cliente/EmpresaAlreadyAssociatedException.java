package com.arq.back.exceptions.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmpresaAlreadyAssociatedException extends RuntimeException{

    public EmpresaAlreadyAssociatedException(String message) {
        super(message);
    }
}
