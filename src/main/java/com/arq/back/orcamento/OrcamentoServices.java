package com.arq.back.orcamento;

import com.arq.back.exceptions.orcamento.OrcamentoNotFoundException;
import com.arq.back.servicocontrato.ServicoContrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrcamentoServices {

    @Autowired
    OrcamentoRepository orcamentoRepository;

    public Set<ServicoContrato> findAllServicos(Long orcamentoId) {
        Orcamento orcamento = returnOrcamentoOrThrowException(orcamentoId);
        return orcamento.getServicosContratos();
    }

    private Orcamento returnOrcamentoOrThrowException(Long empresaId){
        return orcamentoRepository.findById(empresaId)
                .orElseThrow(() -> new OrcamentoNotFoundException("Não há orcamento com o Id: " + empresaId));
    }
}
