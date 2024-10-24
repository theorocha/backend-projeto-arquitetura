package com.arq.back.statusorcamento;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status-orcamento")
@Schema(description = "Controlador de razões de encerramento")
public class StatusOrcamentoResource {

    @Autowired
    StatusOrcamentoService statusOrcamentoService;

    @Operation(summary = "Exclui status orçamento por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        statusOrcamentoService.deleteById(empresaId, id);
    }
}
