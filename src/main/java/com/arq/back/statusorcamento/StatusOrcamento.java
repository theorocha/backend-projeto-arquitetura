package com.arq.back.statusorcamento;

import com.arq.back.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "status_orcamento")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Status do orçamento")
public class StatusOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @Schema(description = "Descricao do status", example = "Em análise")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @NotNull
    @JsonIgnore
    @Schema(description = "Empresa do serviço status servico", example = "Pendente")
    private Empresa empresa;
}
