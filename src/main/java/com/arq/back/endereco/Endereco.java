package com.arq.back.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Endereço completo")
public class Endereco {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "País do endereço", example = "Brasil")
    private String pais;

    @NotNull
    @Schema(description = "Estado do endereço", example = "DF")
    private String estado;

    @NotNull
    @Schema(description = "Cep do endereço", example = "71680-376")
    private String cep;

    @NotNull
    @Schema(description = "Logradouro/endereço completo", example = "Condomínio Jardins do Lago quadra 2")
    private String logradouro;

    @NotNull
    @Schema(description = "Bairro do endereço", example = "Jardim Botânico")
    private String bairro;

    @Schema(description = "Número do endereço", example = "2")
    private Integer numero;

    @Schema(description = "Complemento do endereço", example = "Cj 2 Casa 4")
    private String complemento;
}
