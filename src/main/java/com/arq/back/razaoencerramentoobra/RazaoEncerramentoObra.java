package com.arq.back.razaoencerramentoobra;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
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
}
