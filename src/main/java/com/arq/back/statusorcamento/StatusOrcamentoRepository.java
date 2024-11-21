package com.arq.back.statusorcamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StatusOrcamentoRepository extends JpaRepository<StatusOrcamento, Long> {
    Set<StatusOrcamento> findByEmpresaIdOrderByIdAsc(Long empresaId);
}
