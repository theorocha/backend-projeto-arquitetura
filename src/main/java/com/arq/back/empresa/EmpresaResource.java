package com.arq.back.empresa;

import com.arq.back.administrador.Administrador;
import com.arq.back.cliente.Cliente;
import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import com.arq.back.servicoextra.ServicoExtra;
import com.arq.back.servicoprestado.ServicoPrestado;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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

    @Operation(summary = "Obtém empresa pelo Id")
    @GetMapping("{empresaId}")
    public Empresa findById(@PathVariable Long empresaId){
        return empresaServices.findById(empresaId);
    }


    @Operation(summary = "Obter todos os clientes de uma empresa")
    @GetMapping("{empresa-id}/clientes")
    public Set<Cliente> findAllClientes(@PathVariable("empresa-id") Long empresaId){
        return empresaServices.findAllClientesEmpresa(empresaId);
    }

    @Operation(summary = "Obter todos os administradores de uma empresa")
    @GetMapping("{empresa-id}/administradores")
    public Set<Administrador> findAllAdministradores(@PathVariable("empresa-id") Long empresaId){
        return empresaServices.findAllAdministradoresEmpresa(empresaId);
    }

    @Operation(summary = "Obter todos os serviços extras de uma empresa")
    @GetMapping("{empresa-id}/servicos-extras")
    public Set<ServicoExtra> findAllServicosExtras(@PathVariable("empresa-id") Long empresaId){
        return empresaServices.findAllServicosExtrasEmpresa(empresaId);
    }

    @Operation(summary = "Obter todos os serviços prestados de uma empresa")
    @GetMapping("{empresa-id}/servicos-prestados")
    public Set<ServicoPrestado> findAllServicosPrestados(@PathVariable("empresa-id") Long empresaId){
        return empresaServices.findAllServicosPrestadosEmpresa(empresaId);
    }

    @Operation(summary = "Obter todos os serviços prestados de uma empresa")
    @GetMapping("{empresa-id}/orcamentos")
    public Set<OrcamentoContrato> findAllOrcamentos(@PathVariable("empresa-id") Long empresaId){
        return empresaServices.findAllOrcamentos(empresaId);
    }
}
