package com.arq.back.cliente;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.cliente.ClienteNotFoundException;
import com.arq.back.exceptions.cliente.EmpresaAlreadyAssociatedException;
import com.arq.back.exceptions.empresa.EmpresaNotFoundException;
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
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> {
                    return new ClienteNotFoundException("Não há cliente com o Id: " + clienteId);
                });
        return cliente.getEmpresas();
    }

    public ResponseEntity<Cliente> addEmpresaToEmpresas(Long clienteId, Long empresaId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> {
                    return new ClienteNotFoundException("Não há cliente com o Id: " + clienteId);
                });
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
}
