package com.arq.back.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServices {

    @Autowired
    EmpresaRepository empresaRepository;


    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }
}
