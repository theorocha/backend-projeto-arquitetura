package com.arq.back.razaoencerramentoobra;


import com.arq.back.exceptions.razaoencerramento.RazaoEncerramentoAssociadaException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.obra.ObraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaoEncerramentoObraService {

    @Autowired
    RazaoEncerramentoObraRepository razaoEncerramentoObraRepository;

    @Autowired
    ObraRepository obraRepository;


    public void deleteById(Long empresaId, Long id) {
        RazaoEncerramentoObra razao = razaoEncerramentoObraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Razão de encerramento não encontrada"));

        if (obraRepository.existsByRazaoEncerramentoObraId(id)) {
            throw new RazaoEncerramentoAssociadaException("Não é possível deletar a razão de encerramento porque há obras que a utilizam.");
        }
        if (!razao.getEmpresa().getId().equals(empresaId) ){
            throw new UnauthorizedAccessException("Você não tem permissão para deletar esta razão de encerramento.");
        }
        razaoEncerramentoObraRepository.deleteById(id);
    }
}
