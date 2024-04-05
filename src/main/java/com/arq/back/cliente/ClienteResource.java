package com.arq.back.cliente;

import com.arq.back.empresa.Empresa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/cliente")
@Schema(description = "Controlador de cliente")
public class ClienteResource {

    @Autowired
    ClienteServices clienteServices;

    @Operation(summary = "Obter todas as empresas de um cliente")
    @GetMapping("{cliente-id}/empresas")
    public Set<Empresa> findAllEmpresaCliente(@PathVariable("cliente-id") Long clienteId){
        return clienteServices.findAllEmpresaCliente(clienteId);
    }
}
