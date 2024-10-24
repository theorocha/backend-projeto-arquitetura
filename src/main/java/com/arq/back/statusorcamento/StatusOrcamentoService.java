package com.arq.back.statusorcamento;

import com.arq.back.exceptions.orcamento.StatusOrcamentoAssociadaException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.orcamento.OrcamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusOrcamentoService {
    @Autowired
    StatusOrcamentoRepository statusOrcamentoRepository;

    @Autowired
    OrcamentoRepository orcamentoRepository;

    public void deleteById(Long empresaId, Long id) {
        StatusOrcamento status = statusOrcamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Status do orçamento não encontrado."));

        if (orcamentoRepository.existsByStatusId(id)) {
            throw new StatusOrcamentoAssociadaException("Não é possível deletar o status de orçamento porque há contratos que o utilizam.");
        }
        if (!status.getEmpresa().getId().equals(empresaId) ){
            throw new UnauthorizedAccessException("Você não tem permissão para deletar este status de orçamento.");
        }
        statusOrcamentoRepository.deleteById(id);
    }
}
