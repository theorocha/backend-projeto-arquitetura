package com.arq.back.administrador;

import com.arq.back.empresa.Empresa;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "administrador")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Administrador da empresa")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Nome do administrador da empresa", example = "João Silva")
    private String nome;

    @NotNull
    @Schema(description = "CPF do adm da empresa", example = "999.134.314-22")
    private String cpf;

    @NotNull
    @Schema(description = "Senha", example = "123-Theo!#")
    private String senha;

    @ManyToOne
    @NotNull
    @Schema(description = "Empresa", example = "Arqline")
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
