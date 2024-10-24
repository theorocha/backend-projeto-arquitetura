package com.arq.back.servicocontrato;

import com.arq.back.imagem.Imagem;
import com.arq.back.obra.Obra;
import com.arq.back.orcamento.Orcamento;
import com.arq.back.servicoprestado.ServicoPrestado;
import com.arq.back.statusservico.StatusServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "servico_contrato",
        uniqueConstraints = @UniqueConstraint(columnNames = {"orcamento_id", "servico_prestado_id"})
)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Serviço atrelado ao contrato")
public class ServicoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_id")
    @Schema(description = "Status do servico", example = "FINALIZADO")
    private StatusServico status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "servico_prestado_id")
    @Schema(description = "Servico prestado da empresa", example = "Alvenaria")
    private ServicoPrestado servicoPrestado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    @Schema(description = "Orçamento", example = "Alvenaria")
    private Orcamento orcamento;

    @JsonIgnore
    @OneToMany(mappedBy = "servicoContrato", cascade = CascadeType.ALL)
    private Set<Imagem> imagens = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;
}
