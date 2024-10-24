package com.arq.back.orcamento;

import com.arq.back.servicocontrato.ServicoContrato;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/orcamento")
public class OrcamentoResource {

    @Autowired
    OrcamentoServices orcamentoServices;

    @Operation(summary = "Obter todos os serviços que constam em um orçamento")
    @GetMapping("{orcamento-id}/servicos")
    public Set<ServicoContrato> findAllServicos(@PathVariable("orcamento-id") Long orcamentoId){
        return orcamentoServices.findAllServicos(orcamentoId);
    }
}
