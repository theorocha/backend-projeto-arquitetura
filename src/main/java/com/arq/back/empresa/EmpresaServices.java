package com.arq.back.empresa;

import com.arq.back.administrador.Administrador;
import com.arq.back.cliente.Cliente;
import com.arq.back.exceptions.empresa.EmpresaNotFoundException;
import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import com.arq.back.servicoextra.ServicoExtra;
import com.arq.back.servicoprestado.ServicoPrestado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmpresaServices {

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }


    public Set<Cliente> findAllClientesEmpresa(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getClientes();
    }

    public Set<Administrador> findAllAdministradoresEmpresa(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getAdministradores();
    }

    public Set<ServicoExtra> findAllServicosExtrasEmpresa(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getServicosExtras();
    }

    public Set<ServicoPrestado> findAllServicosPrestadosEmpresa(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getServicosPrestados();
    }

    public Set<OrcamentoContrato> findAllOrcamentos(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getOrcamentos();
    }

    private Empresa returnEmpresaOrThrowException(Long empresaId){
        return empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EmpresaNotFoundException("Não há empresa com o Id: " + empresaId));
    }
}
