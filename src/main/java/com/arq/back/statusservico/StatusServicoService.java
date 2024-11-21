package com.arq.back.statusservico;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.statusorcamento.StatusOrcamentoAssociadoException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.servicocontrato.ServicoContratoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServicoService {

    @Autowired
    StatusServicoRepository statusServicoRepository;

    @Autowired
    ServicoContratoRepository servicoContratoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public void deleteById(Long empresaId, Long id) {
        StatusServico status = statusServicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Status do serviço não encontrado."));

        if (servicoContratoRepository.existsByStatusId(id)) {
            throw new StatusOrcamentoAssociadoException("Não é possível deletar o status de serviço porque há serviços que o utilizam.");
        }
        if (!status.getEmpresa().getId().equals(empresaId) ){
            throw new UnauthorizedAccessException("Você não tem permissão para deletar este status de serviço.");
        }
        statusServicoRepository.deleteById(id);
    }

    public StatusServico criarStatusServico(StatusServico statusServico, Long empresaId) {
        Optional<Empresa> empresa = empresaRepository.findById(empresaId);
        statusServico.setEmpresa(empresa.get());
        return statusServicoRepository.save(statusServico);
    }
}
