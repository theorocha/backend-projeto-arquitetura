package com.arq.back.servicoextra;

import com.arq.back.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "servico_extra")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Serviço extra atrelada à empresa")
public class ServicoExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Integer id;

    @NotNull
    @Schema(description = "Descricao do servico extra", example = "Marketing digital")
    private String descricao;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @NotNull
    private Empresa empresa;

}
