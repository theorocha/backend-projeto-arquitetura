package com.arq.back.exceptions.orcamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class StatusOrcamentoAssociadaException extends RuntimeException {
    public StatusOrcamentoAssociadaException(String message) {
        super(message);
    }
}
