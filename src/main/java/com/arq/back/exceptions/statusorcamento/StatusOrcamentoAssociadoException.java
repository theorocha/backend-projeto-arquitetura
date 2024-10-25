package com.arq.back.exceptions.statusorcamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class StatusOrcamentoAssociadoException extends RuntimeException {
    public StatusOrcamentoAssociadoException(String message) {
        super(message);
    }
}
