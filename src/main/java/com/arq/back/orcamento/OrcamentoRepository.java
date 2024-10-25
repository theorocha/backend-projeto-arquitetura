package com.arq.back.orcamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    boolean existsByStatusId(Long id);

    boolean existsByServicosExtras_Id(Long id);
}
