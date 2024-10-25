package com.arq.back.statusservico;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status-servico")
@Schema(description = "Controlador de status de serviço.")
public class StatusServicoResource {

    @Autowired
    StatusServicoServico statusServicoServico;

    @Operation(summary = "Exclui status serviço por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        statusServicoServico.deleteById(empresaId, id);
    }
}
