package com.arq.back.empresa;

import com.arq.back.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT c FROM Cliente c JOIN c.empresas e WHERE e.id = :empresaId")
    Set<Cliente> findAllClientesDaEmpresa(Long empresaId);
}
