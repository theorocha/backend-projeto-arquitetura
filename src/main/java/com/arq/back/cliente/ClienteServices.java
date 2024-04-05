package com.arq.back.cliente;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.ClienteNotFoundException;
import com.arq.back.exceptions.EmpresaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public Set<Cliente> findAllClientesEmpresa(Long empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> {
                    return new EmpresaNotFoundException("Não há empresa com esse id.");
                });
        return empresaRepository.findAllClientesDaEmpresa(empresaId);
    }

    public Set<Empresa> findAllEmpresaCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> {
                    return new ClienteNotFoundException("Não há cliente com esse id.");
                });
        return cliente.getEmpresas();
    }
}
