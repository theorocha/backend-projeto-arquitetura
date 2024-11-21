package com.arq.back.servicoextra;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servico-extra")
@Schema(description = "Controlador de serviço extra")
public class ServicoExtraResource {

    @Autowired
    ServicoExtraService servicoExtraService;

    @Operation(summary = "Cria novo serviço extra")
    @PostMapping("/empresa/{empresaId}")
    public ResponseEntity<ServicoExtra> criarServicoExtra(
            @PathVariable Long empresaId,
            @RequestBody ServicoExtra  servicoExtra) {
        servicoExtra = servicoExtraService.criarServicoExtra(servicoExtra, empresaId);
        return ResponseEntity.ok(servicoExtra);
    }

    @Operation(summary = "Exclui serviço extra por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        servicoExtraService.deleteById(empresaId, id);
    }
}
