package com.arq.back.exceptions.servicoextra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ServicoExtraAssociadoException extends RuntimeException {
    public ServicoExtraAssociadoException(String message) {
        super(message);
    }
}
