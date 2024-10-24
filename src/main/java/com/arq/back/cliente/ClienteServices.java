package com.arq.back.cliente;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.cliente.ClienteNotFoundException;
import com.arq.back.exceptions.empresa.EmpresaAlreadyAssociatedException;
import com.arq.back.exceptions.empresa.EmpresaNotFoundException;
import com.arq.back.orcamento.Orcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public Set<Empresa> findAllEmpresaCliente(Long clienteId) {
        Cliente cliente = returnClientOrThrowException(clienteId);
        return cliente.getEmpresas();
    }

    public ResponseEntity<Cliente> addEmpresaToEmpresas(Long clienteId, Long empresaId) {
        Cliente cliente = returnClientOrThrowException(clienteId);
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EmpresaNotFoundException("Não há empresa com o Id: " + empresaId));

        if (cliente.getEmpresas().contains(empresa)) {
            throw new EmpresaAlreadyAssociatedException("A empresa de id: " + empresaId +
                    " já está associada ao cliente de id: " + clienteId);
        }
        cliente.getEmpresas().add(empresa);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    public Set<Orcamento> findAllOrcamento(Long clienteId) {
        Cliente cliente = returnClientOrThrowException(clienteId);
        return cliente.getOrcamentos();
    }

    public void deleteById(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public Cliente returnClientOrThrowException(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNotFoundException("Não há cliente com o Id: " + clienteId));
    }
}
