package com.arq.back.razaoencerramentoobra;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaoEncerramentoObraService {

    @Autowired
    RazaoEncerramentoObraRepository razaoEncerramentoObraRepository;


    public void deleteById(Long id) {
        razaoEncerramentoObraRepository.deleteById(id);
    }
}
