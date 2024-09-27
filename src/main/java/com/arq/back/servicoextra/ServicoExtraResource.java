package com.arq.back.servicoextra;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servico-extra")
@Schema(description = "Controlador de serviço extra")
public class ServicoExtraResource {

    @Autowired
    ServicoExtraServices servicoExtraServices;
}
