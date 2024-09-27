package com.arq.back.empresa;

import com.arq.back.administrador.Administrador;
import com.arq.back.cliente.Cliente;
import com.arq.back.cliente.ClienteRepository;
import com.arq.back.cliente.ClienteServices;
import com.arq.back.exceptions.empresa.EmpresaNotFoundException;
import com.arq.back.obra.Obra;
import com.arq.back.obra.ObraRepository;
import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import com.arq.back.razaoencerramentoobra.RazaoEncerramentoObra;
import com.arq.back.servicoextra.ServicoExtra;
import com.arq.back.servicoprestado.ServicoPrestado;
import com.arq.back.statusorcamento.StatusOrcamento;
import com.arq.back.statusservico.StatusServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpresaServices {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ObraRepository obraRepository;

    @Autowired
    ClienteServices clienteServices;

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(Long empresaId) {
        return returnEmpresaOrThrowException(empresaId);
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
        Set<ServicoPrestado> servicosPrestados = empresa.getServicosPrestados();
        List<ServicoPrestado> sortedServicos = new ArrayList<>(servicosPrestados);
        sortedServicos.sort(Comparator.comparing(ServicoPrestado::getId));
        return new LinkedHashSet<>(sortedServicos);
    }

    public Set<OrcamentoContrato> findAllOrcamentos(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getOrcamentos();
    }

    public ResponseEntity<Cliente> saveClienteToEmpresa(Long empresaId, Cliente cliente) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        Long nextId = clienteRepository.findMaxId() + 1;
        cliente.setId(nextId);
        cliente.getEmpresas().add(empresa);
        Cliente newCliente = clienteRepository.save(cliente);
        empresa.getClientes().add(newCliente);
        empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
    }

    public void deleteClienteFromEmpresa(Long empresaId, Long clienteId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        Cliente cliente = clienteServices.returnClientOrThrowException(clienteId);
        empresa.getClientes().remove(cliente);
        cliente.getEmpresas().remove(empresa);
        empresaRepository.save(empresa);
        clienteRepository.save(cliente);
    }

    public Set<Obra> findAllObra(Long empresaId) {
        return obraRepository.findByOrcamentoContratoEmpresaId(empresaId);
    }

    public Set<RazaoEncerramentoObra> findAllfindAllRazoesObra(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getRazaoEncerramentoObras();
    }


    public Set<StatusServico> findAllStatusServico(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        return empresa.getStatusServico();
    }

    public Set<StatusOrcamento> findAllStatusOrcamento(Long empresaId) {
        Empresa empresa = returnEmpresaOrThrowException(empresaId);
        Set<StatusOrcamento> statusOrcamentos = empresa.getStatusOrcamento();
        List<StatusOrcamento> sortedStatus = new ArrayList<>(statusOrcamentos);
        sortedStatus.sort(Comparator.comparing(StatusOrcamento::getId));
        return new LinkedHashSet<>(sortedStatus);
    }

    private Empresa returnEmpresaOrThrowException(Long empresaId){
        return empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EmpresaNotFoundException("Não há empresa com o Id: " + empresaId));
    }
}
