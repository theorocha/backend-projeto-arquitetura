package com.arq.back.exceptions.obra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RazaoEncerramentoAssociadaException extends RuntimeException {
    public RazaoEncerramentoAssociadaException(String message) {
        super(message);
    }
}
