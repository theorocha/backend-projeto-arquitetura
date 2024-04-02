package com.arq.back.statusservico;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servico_extra")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Status do serviço")
public class StatusServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Descricao do status", example = "FINALIZADO")
    private String descricao;
}
