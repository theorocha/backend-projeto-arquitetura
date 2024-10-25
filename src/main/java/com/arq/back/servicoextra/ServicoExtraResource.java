package com.arq.back.servicoextra;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servico-extra")
@Schema(description = "Controlador de serviço extra")
public class ServicoExtraResource {

    @Autowired
    ServicoExtraServices servicoExtraServices;

    @Operation(summary = "Exclui serviço extra por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        servicoExtraServices.deleteById(empresaId, id);
    }
}
