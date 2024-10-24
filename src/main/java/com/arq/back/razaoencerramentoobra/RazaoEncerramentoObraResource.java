package com.arq.back.razaoencerramentoobra;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/razao-encerramento")
@Schema(description = "Controlador de razões de encerramento")
public class RazaoEncerramentoObraResource {

    @Autowired
    RazaoEncerramentoObraService razaoEncerramentoObraService;

    @Operation(summary = "Exclui razão de encerramento por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        razaoEncerramentoObraService.deleteById(empresaId, id);
    }
}
