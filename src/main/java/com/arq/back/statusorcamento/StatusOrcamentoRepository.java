package com.arq.back.statusorcamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOrcamentoRepository extends JpaRepository<StatusOrcamento, Long> {
}
