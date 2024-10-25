package com.arq.back.exceptions.statusservico;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class StatusServicoAssociadoException extends RuntimeException {
    public StatusServicoAssociadoException(String message) {
        super(message);
    }
}
