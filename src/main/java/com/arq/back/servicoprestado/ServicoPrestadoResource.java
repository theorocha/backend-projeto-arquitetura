package com.arq.back.servicoprestado;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servico-prestado")
@Schema(description = "Controlador de serviço prestado")
public class ServicoPrestadoResource {

    @Autowired
    ServicoPrestadoService servicoPrestadoService;

    @Operation(summary = "Exclui serviço prestado por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        servicoPrestadoService.deleteById(empresaId, id);
    }
}
