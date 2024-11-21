package com.arq.back.servicoprestado;

import com.arq.back.servicoextra.ServicoExtra;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servico-prestado")
@Schema(description = "Controlador de serviço prestado")
public class ServicoPrestadoResource {

    @Autowired
    ServicoPrestadoService servicoPrestadoService;

    @Operation(summary = "Cria novo serviço prestado")
    @PostMapping("/empresa/{empresaId}")
    public ResponseEntity<ServicoPrestado> criarServicoPrestado(
            @PathVariable Long empresaId,
            @RequestBody ServicoPrestado servicoPrestado) {
        servicoPrestado = servicoPrestadoService.criarServicoPrestado(servicoPrestado, empresaId);
        return ResponseEntity.ok(servicoPrestado);
    }


    @Operation(summary = "Exclui serviço prestado por id")
    @DeleteMapping("{id}/empresa/{empresaId}")
    public void deleteById(@PathVariable("id") Long id, @PathVariable ("empresaId") Long empresaId){
        servicoPrestadoService.deleteById(empresaId, id);
    }
}
