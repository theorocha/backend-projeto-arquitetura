package com.arq.back.empresa;

import com.arq.back.cliente.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/empresa")
@Schema(description = "Controlador de empresa")
public class EmpresaResource {

    @Autowired
    EmpresaServices empresaServices;

    @Operation(summary = "Obter lista de todas as empresas")
    @GetMapping
    public List<Empresa> findAll(){
        return empresaServices.findAll();
    }


    @Operation(summary = "Obter todos os clientes de uma empresa")
    @GetMapping("{empresa-id}/clientes")
    private Set<Cliente> findAllClientesDaEmpresa(@PathVariable("empresa-id") Long empresaId){
        return empresaServices.findAllClientesEmpresa(empresaId);
    }

}
