package com.arq.back.servicoextra;

import com.arq.back.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoExtraRepository extends JpaRepository<ServicoExtra, Long> {
    List<ServicoExtra> findAllByEmpresa(Optional<Empresa> empresa);
}
