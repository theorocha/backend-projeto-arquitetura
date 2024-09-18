package com.arq.back.obra;

import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import com.arq.back.razaoencerramentoobra.RazaoEncerramentoObra;
import com.arq.back.servicocontrato.ServicoContrato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "obra")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Razão encerramento obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @Schema(description = "Obra Ativa", example = "0/1")
    private Boolean ativa;

    @JsonIgnore
    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL)
    private Set<ServicoContrato> servicosContratos = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "orcamento_id")
    private OrcamentoContrato orcamentoContrato;

    @ManyToOne
    @JoinColumn(name = "razao_encerramento")
    @Schema(description = "razao encerramento da obra", example = "Obra finalizada")
    private RazaoEncerramentoObra razaoEncerramentoObra;
}
