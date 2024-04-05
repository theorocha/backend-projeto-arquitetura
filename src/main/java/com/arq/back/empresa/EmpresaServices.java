package com.arq.back.empresa;

import com.arq.back.cliente.Cliente;
import com.arq.back.cliente.ClienteRepository;
import com.arq.back.exceptions.ClienteNotFoundException;
import com.arq.back.exceptions.EmpresaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmpresaServices {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ClienteRepository clienteRepository;


    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }


    public Set<Cliente> findAllClientesEmpresa(Long empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> {
                    return new EmpresaNotFoundException("Não há empresa com esse id.");
                });
        return empresaRepository.findAllClientesDaEmpresa(empresaId);
    }
}
