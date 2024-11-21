package com.arq.back.statusorcamento;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.statusorcamento.StatusOrcamentoAssociadoException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.orcamento.OrcamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusOrcamentoService {

    @Autowired
    StatusOrcamentoRepository statusOrcamentoRepository;

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public void deleteById(Long empresaId, Long id) {
        StatusOrcamento status = statusOrcamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Status do orçamento não encontrado."));

        if (orcamentoRepository.existsByStatusId(id)) {
            throw new StatusOrcamentoAssociadoException("Não é possível deletar o status de orçamento porque há contratos que o utilizam.");
        }
        if (!status.getEmpresa().getId().equals(empresaId) ){
            throw new UnauthorizedAccessException("Você não tem permissão para deletar este status de orçamento.");
        }
        statusOrcamentoRepository.deleteById(id);
    }

    public StatusOrcamento criarStatusOrcamento(StatusOrcamento statusOrcamento, Long empresaId) {
        Optional<Empresa> empresa = empresaRepository.findById(empresaId);
        statusOrcamento.setEmpresa(empresa.get());
        return statusOrcamentoRepository.save(statusOrcamento);
    }
}
