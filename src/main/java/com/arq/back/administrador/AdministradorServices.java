package com.arq.back.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServices {

    @Autowired
    AdministradorRepository administradorRepository;

}
