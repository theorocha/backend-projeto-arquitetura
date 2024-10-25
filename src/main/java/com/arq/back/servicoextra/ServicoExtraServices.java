package com.arq.back.servicoextra;

import com.arq.back.exceptions.servicoextra.ServicoExtraAssociadoException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.orcamento.OrcamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoExtraServices {

    @Autowired
    ServicoExtraRepository servicoExtraRepository;

    @Autowired
    OrcamentoRepository orcamentoRepository;

    public void deleteById(Long empresaId, Long id) {
        ServicoExtra servico = servicoExtraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço extra não encontrado."));

        if (orcamentoRepository.existsByServicosExtras_Id(id)) {
            throw new ServicoExtraAssociadoException("Não é possível deletar o serviço porque há orçamentos que o utilizam.");
        }
        if (!servico.getEmpresa().getId().equals(empresaId)) {
            throw new UnauthorizedAccessException("Você não tem permissão para deletar este serviço.");
        }
        servicoExtraRepository.deleteById(id);
    }
}
