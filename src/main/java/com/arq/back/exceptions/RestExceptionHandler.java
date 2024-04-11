package com.arq.back.exceptions;

import com.arq.back.exceptions.cliente.ClienteNotFoundException;
import com.arq.back.exceptions.cliente.EmpresaAlreadyAssociatedException;
import com.arq.back.exceptions.empresa.EmpresaNotFoundException;
import com.arq.back.exceptions.orcamento.OrcamentoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClienteNotFoundException.class)
    private ResponseEntity<RestErrorMessage> clienteNotFoundHandler(ClienteNotFoundException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(EmpresaNotFoundException.class)
    private ResponseEntity<RestErrorMessage> empresaNotFoundHandler(EmpresaNotFoundException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(OrcamentoNotFoundException.class)
    private ResponseEntity<RestErrorMessage> orcamentoNotFoundHandler(OrcamentoNotFoundException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(EmpresaAlreadyAssociatedException.class)
    private ResponseEntity<RestErrorMessage> empresaAlreadyAssociatedHandler(EmpresaAlreadyAssociatedException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
