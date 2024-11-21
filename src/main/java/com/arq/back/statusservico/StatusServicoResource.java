package com.arq.back.statusservico;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/status-servico")
@Schema(description = "Controlador de status de serviço.")
public class StatusServicoResource {

    @Autowired
    StatusServicoService statusServicoService;

    @Operation(summary = "Cria novo status de serviço")
    @PostMapping("/empresa/{empresaId}")
    public ResponseEntity<StatusServico> criarStatusServico(
            @PathVariable Long empresaId,
            @RequestBody StatusServico statusServico) {
        statusServico = statusServicoService.criarStatusServico(statusServico, empresaId);
        return ResponseEntity.ok(statusServico);
    }

    @Operation(summary = "Exclui status serviço por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        statusServicoService.deleteById(empresaId, id);
    }
}
