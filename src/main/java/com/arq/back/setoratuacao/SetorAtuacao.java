package com.arq.back.setoratuacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "setor_atuacao")
@Schema(description = "Setor de atuação profissional")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class SetorAtuacao {

    @Id
    @Schema(description = "Identificador único", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Schema(description = "Descrição do setor de atuação", example = "Arquitetura e interiores")
    private String descricao;
}
