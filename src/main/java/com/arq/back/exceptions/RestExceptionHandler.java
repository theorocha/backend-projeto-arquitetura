package com.arq.back.exceptions;

import com.arq.back.exceptions.cliente.ClienteNotFoundException;
import com.arq.back.exceptions.empresa.EmpresaAlreadyAssociatedException;
import com.arq.back.exceptions.empresa.EmpresaNotFoundException;
import com.arq.back.exceptions.razaoencerramento.RazaoEncerramentoAssociadaException;
import com.arq.back.exceptions.orcamento.OrcamentoNotFoundException;
import com.arq.back.exceptions.servicoextra.ServicoExtraAssociadoException;
import com.arq.back.exceptions.servicoprestado.ServicoPrestadoAssociadoException;
import com.arq.back.exceptions.statusorcamento.StatusOrcamentoAssociadoException;
import com.arq.back.exceptions.statusservico.StatusServicoAssociadoException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
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
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(RazaoEncerramentoAssociadaException.class)
    private ResponseEntity<RestErrorMessage> razaoEncerramentoAssociadaHandler(RazaoEncerramentoAssociadaException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(StatusOrcamentoAssociadoException.class)
    private ResponseEntity<RestErrorMessage> statusOrcamentoAssociadoHandler(StatusOrcamentoAssociadoException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(StatusServicoAssociadoException.class)
    private ResponseEntity<RestErrorMessage> statusServicoAssociadoHandler(StatusServicoAssociadoException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(ServicoExtraAssociadoException.class)
    private ResponseEntity<RestErrorMessage> servicoExtraAssociadoHandler(ServicoExtraAssociadoException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(ServicoPrestadoAssociadoException.class)
    private ResponseEntity<RestErrorMessage> servicoPrestadoAssociadoHandler(ServicoPrestadoAssociadoException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    private ResponseEntity<RestErrorMessage> unathorizedHandler(UnauthorizedAccessException exception){
        RestErrorMessage message = new RestErrorMessage(HttpStatus.UNAUTHORIZED, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }
}