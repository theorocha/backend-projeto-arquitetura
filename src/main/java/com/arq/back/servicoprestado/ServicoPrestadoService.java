package com.arq.back.servicoprestado;

import com.arq.back.empresa.Empresa;
import com.arq.back.empresa.EmpresaRepository;
import com.arq.back.exceptions.servicoprestado.ServicoPrestadoAssociadoException;
import com.arq.back.exceptions.util.UnauthorizedAccessException;
import com.arq.back.servicocontrato.ServicoContratoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoPrestadoService {

    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    ServicoContratoRepository servicoContratoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public void deleteById(Long empresaId, Long id) {
        ServicoPrestado servico = servicoPrestadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço prestado não encontrado."));

        if (servicoContratoRepository.existsByServicoPrestado_Id(id)) {
            throw new ServicoPrestadoAssociadoException("Não é possível deletar o serviço porque há orçamentos que o utilizam.");
        }
        if (!servico.getEmpresa().getId().equals(empresaId)) {
            throw new UnauthorizedAccessException("Você não tem permissão para deletar este serviço.");
        }
        servicoPrestadoRepository.deleteById(id);
    }

    public ServicoPrestado criarServicoPrestado(ServicoPrestado servicoPrestado, Long empresaId) {
        Optional<Empresa> empresa = empresaRepository.findById(empresaId);
        servicoPrestado.setEmpresa(empresa.get());
        return servicoPrestadoRepository.save(servicoPrestado);
    }
}
