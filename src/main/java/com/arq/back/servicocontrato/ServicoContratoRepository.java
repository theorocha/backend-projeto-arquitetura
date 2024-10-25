package com.arq.back.servicocontrato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoContratoRepository extends JpaRepository<ServicoContrato, Integer> {
    boolean existsByStatusId(Long id);

    boolean existsByServicoPrestado_Id(Long servicoPrestadoId);
}
