package com.arq.back.servicoextra;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.servicoextra.ServicoExtraAssociadoException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.orcamento.OrcamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoExtraService {

    @Autowired
    ServicoExtraRepository servicoExtraRepository;

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

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

    public ServicoExtra criarServicoExtra(ServicoExtra servicoExtra, Long empresaId) {
        Optional<Empresa> empresa = empresaRepository.findById(empresaId);
        servicoExtra.setEmpresa(empresa.get());
        return servicoExtraRepository.save(servicoExtra);
    }
}
