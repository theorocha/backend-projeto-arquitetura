package com.arq.back.statusorcamento;

import com.arq.back.razaoencerramentoobra.RazaoEncerramentoObra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/status-orcamento")
@Schema(description = "Controlador de status de orçamento.")
public class StatusOrcamentoResource {

    @Autowired
    StatusOrcamentoService statusOrcamentoService;

    @Operation(summary = "Cria novo status de orçamento")
    @PostMapping("/empresa/{empresaId}")
    public ResponseEntity<StatusOrcamento> criarStatusOrcamento(
            @PathVariable Long empresaId,
            @RequestBody StatusOrcamento statusOrcamento) {
        statusOrcamento = statusOrcamentoService.criarStatusOrcamento(statusOrcamento, empresaId);
        return ResponseEntity.ok(statusOrcamento);
    }

    @Operation(summary = "Exclui status orçamento por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        statusOrcamentoService.deleteById(empresaId, id);
    }
}
