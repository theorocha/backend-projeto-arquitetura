package com.arq.back.razaoencerramentoobra;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/razao-encerramento")
@Schema(description = "Controlador de razões de encerramento")
public class RazaoEncerramentoObraResource {

    @Autowired
    RazaoEncerramentoObraService razaoEncerramentoObraService;

    @PostMapping("/empresa/{empresaId}")
    public ResponseEntity<RazaoEncerramentoObra> criarRazaoEncerramento(
            @PathVariable Long empresaId,
            @RequestBody RazaoEncerramentoObra razaoEncerramento) {
        razaoEncerramento = razaoEncerramentoObraService.criarRazaoEncerramento(razaoEncerramento, empresaId);
        return ResponseEntity.ok(razaoEncerramento);
    }

    @Operation(summary = "Exclui razão de encerramento por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        razaoEncerramentoObraService.deleteById(empresaId, id);
    }
}
