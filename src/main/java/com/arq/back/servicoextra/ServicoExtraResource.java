package com.arq.back.servicoextra;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servico-extra")
@Schema(description = "Controlador de serviço extra")
public class ServicoExtraResource {

    @Autowired
    ServicoExtraServices servicoExtraServices;

    @Operation(summary = "Obter todos os serviços extra de uma empresa")
    @GetMapping("/empresa/{empresa-id}")
    public List<ServicoExtra> findAllByEmpresa(@PathVariable("empresa-id") Long id){
        return servicoExtraServices.findAllByEmpresa(id);
    }
}
