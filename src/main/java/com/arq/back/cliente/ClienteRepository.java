package com.arq.back.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT MAX(c.id) FROM Cliente c")
    Long findMaxId();
}
