package com.arq.back.empresa;

import com.arq.back.endereco.Endereco;
import com.arq.back.setoratuacao.SetorAtuacao;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Empresas do sistema")
public class Empresa {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Nome da empresa", example = "1")
    private String nome;

    @NotNull
    @Schema(description = "CNPJ da empresa", example = "11414441/0001-98")
    private String cnpj;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "endereco")
    private Endereco endereco;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "setor_atuacao")
    private SetorAtuacao setorAtuacao;

}
