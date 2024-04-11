package com.arq.back.orcamentoecontrato;

import com.arq.back.cliente.Cliente;
import com.arq.back.empresa.Empresa;
import com.arq.back.endereco.Endereco;
import com.arq.back.servicocontrato.ServicoContrato;
import com.arq.back.statusorcamento.StatusOrcamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orcamento_contrato")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Orçamentos/Contratos")
public class OrcamentoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Descrição da proposta completa do contrato do projeto", example = "O contrato consiste em: X,Y,Z.")
    private String descricao;

    @NotNull
    @Schema(description = "Valor do contrato", example = "5000")
    private Integer valorContrato;

    @NotNull
    @Schema(description = "Data de envio da proposta do contrato", example = "11/02/2023")
    private LocalDate dataEnvio;

    @NotNull
    @Schema(description = "Data de validade da proposta do contrato", example = "19/02/2023")
    private LocalDate dataValidade;

    @Schema(description = "Observação opcional do contrato", example = "Pagamento em dinheiro")
    private String observacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    @Schema(description = "Endereço da obra do contrato", example = "SQS 305, Bloco B, Apt 9")
    private Endereco endereco;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @Schema(description = "Cliente do orçamento", example = "Rui Barbosa")
    private Cliente cliente;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @Schema(description = "Empresa do orçamento", example = "Arqline")
    private Empresa empresa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_id")
    @Schema(description = "Status do orçamento", example = "Aceito")
    private StatusOrcamento status;

    @JsonIgnore
    @OneToMany(mappedBy = "orcamentoContrato", cascade = CascadeType.ALL)
    private Set<ServicoContrato> servicosContratos = new HashSet<>();
}
