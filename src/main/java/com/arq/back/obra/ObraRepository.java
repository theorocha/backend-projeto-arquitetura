package com.arq.back.obra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    Set<Obra> findByOrcamentoEmpresaId(Long empresaId);

    boolean existsByRazaoEncerramentoObraId(Long razaoEncerramentoId);
    }
