package com.arq.back.razaoencerramentoobra;

import com.arq.back.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "razao_encerramento_obra")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Razão encerramento obra")
public class RazaoEncerramentoObra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @Schema(description = "Descricao da razão", example = "Obra finalizada")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @NotNull
    @JsonIgnore
    @Schema(description = "Empresa que  prestado", example = "Arqline")
    private Empresa empresa;
}
