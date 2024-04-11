package com.arq.back.cliente;

import com.arq.back.empresa.Empresa;
import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/cliente")
@Schema(description = "Controlador de cliente")
public class ClienteResource {

    @Autowired
    ClienteServices clienteServices;

    @Operation(summary = "Obter todas as empresas de um cliente")
    @GetMapping("{cliente-id}/empresas")
    public Set<Empresa> findAllEmpresa(@PathVariable("cliente-id") Long clienteId){
        return clienteServices.findAllEmpresaCliente(clienteId);
    }

    @Operation(summary = "Adicionar uma empresa à lista de empresas do cliente")
    @PostMapping("{cliente-id}/empresa/{empresa-id}")
    public ResponseEntity<Cliente> addEmpresaToEmpresas(@PathVariable("cliente-id") Long clienteId,
                                                        @PathVariable("empresa-id") Long empresaId){
        return clienteServices.addEmpresaToEmpresas(clienteId,empresaId);
    }

    @Operation(summary = "Listar todos os orçamentos de um cliente")
    @GetMapping("{cliente-id}/orcamento")
    public Set<OrcamentoContrato> addEmpresaToEmpresas(@PathVariable("cliente-id") Long clienteId){
        return clienteServices.findAllOrcamento(clienteId);
    }
}
