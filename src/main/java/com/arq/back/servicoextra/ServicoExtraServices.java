package com.arq.back.servicoextra;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoExtraServices {

    @Autowired
    ServicoExtraRepository servicoExtraRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public List<ServicoExtra> findAllByEmpresa(Long id) {
        Optional<Empresa> empresaOpcional = empresaRepository.findById(id);
        if (empresaOpcional.isPresent()) {
            Empresa empresa = empresaOpcional.get();
            return servicoExtraRepository.findAllByEmpresa(Optional.of(empresa));
        } else {
            return Collections.emptyList();
        }
    }
}
