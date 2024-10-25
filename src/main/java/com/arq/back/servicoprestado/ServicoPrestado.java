package com.arq.back.servicoprestado;

import com.arq.back.empresa.Empresa;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "servico_prestado")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Serviço extra atrelado à empresa")
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Descricao do servico prestado", example = "Marketing digital")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @NotNull
    @Schema(description = "Empresa do servico prestado", example = "Arqline")
    private Empresa empresa;
}
