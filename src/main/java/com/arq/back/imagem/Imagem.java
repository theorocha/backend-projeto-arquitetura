//package com.arq.back.imagem;
//
//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//
//@Entity
//@Table(name = "servico_prestado")
//@Getter
//@Setter
//@EqualsAndHashCode(of = "id")
//@AllArgsConstructor
//@NoArgsConstructor
//@Schema(description = "Imagens para retratar o andamento dos serviços")
//public class Imagem {
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @Schema(description = "Identificador único da imagem UUID", example = "131432-1243124014-31431")
//    private String id;
//
//    @NotNull
//    @Schema(description = "Nome da imagem", example = "esquadrias")
//    private String nomeDoArquivo;
//
//    @NotNull
//    @Schema(description = "Tipo da imagem", example = "jpg/png")
//    private String tipoDoArquivo;
//
////    @ManyToOne
////    @JoinColumn(name = "servico_id")
////    @NotNull
////    private ServicoOrcamento servico;
//
//    @Lob
//    private byte[] dado;
//}
