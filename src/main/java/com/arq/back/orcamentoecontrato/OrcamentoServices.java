package com.arq.back.orcamentoecontrato;

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
        OrcamentoContrato orcamentoContrato = returnOrcamentoOrThrowException(orcamentoId);
        return orcamentoContrato.getServicosContratos();
    }

    private OrcamentoContrato returnOrcamentoOrThrowException(Long empresaId){
        return orcamentoRepository.findById(empresaId)
                .orElseThrow(() -> new OrcamentoNotFoundException("Não há orcamento com o Id: " + empresaId));
    }
}
