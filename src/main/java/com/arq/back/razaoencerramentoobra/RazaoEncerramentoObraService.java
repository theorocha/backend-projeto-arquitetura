package com.arq.back.razaoencerramentoobra;


import com.arq.back.exceptions.obra.RazaoEncerramentoAssociadaException;
import com.arq.back.obra.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaoEncerramentoObraService {

    @Autowired
    RazaoEncerramentoObraRepository razaoEncerramentoObraRepository;

    @Autowired
    ObraRepository obraRepository;


    public void deleteById(Long id) {
        if (obraRepository.existsByRazaoEncerramentoObraId(id)) {
            throw new RazaoEncerramentoAssociadaException("Não é possível deletar a razão de encerramento porque há obras que a utilizam.");
        }
        razaoEncerramentoObraRepository.deleteById(id);
    }
}
