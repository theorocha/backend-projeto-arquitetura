package com.arq.back.exceptions.orcamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrcamentoNotFoundException extends RuntimeException{

    public OrcamentoNotFoundException(String message) {
        super(message);
    }
}
