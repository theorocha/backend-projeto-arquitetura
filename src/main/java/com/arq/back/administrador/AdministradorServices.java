package com.arq.back.administrador;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServices {

    @Autowired
    AdministradorRepository administradorRepository;

}
