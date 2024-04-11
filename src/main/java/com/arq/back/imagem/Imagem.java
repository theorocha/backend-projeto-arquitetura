package com.arq.back.imagem;

import com.arq.back.servicocontrato.ServicoContrato;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "imagens")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Imagens para retratar o andamento dos serviços")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;


    @NotNull
    @Column(name = "nome_do_arquivo")
    @Schema(description = "Nome da imagem", example = "esquadrias")
    private String nomeDoArquivo;

    @NotNull
    @Column(name = "tipo_do_arquivo")
    @Schema(description = "Tipo da imagem", example = "image/jpeg")
    private String tipoDoArquivo;

    @NotNull
    @Schema(description = "Conteúdo da imagem", example = "1134h4g1g...")
    @Lob
    private byte[] conteudo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "servico_id")
    @Schema(description = "Serviço que a imagem representa", example = "Alvenaria")
    private ServicoContrato servicoContrato;
}
