package com.arq.back.administrador;

import com.arq.back.empresa.Empresa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
@Schema(description = "Controlador do administrador")
public class AdministradorResource {

    @Autowired
    AdministradorServices administradorServices;

    @Operation(summary = "Obter todos os administradores de uma empresa")
    @GetMapping("/empresa/{empresa-id}")
    public List<Administrador> findAllByEmpresa(@PathVariable("empresa-id") Long id){
        return administradorServices.findAllByEmpresa(id);
    }}
