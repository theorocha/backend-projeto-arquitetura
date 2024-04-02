package com.arq.back.empresa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Schema(description = "Controlador de empresa")
public class EmpresaResource {

    @Autowired
    EmpresaServices empresaServices;

    @Operation(summary = "Obter lista de todas as empresas")
    public List<Empresa> findAll(){
        return empresaServices.findAll();
    }
}
