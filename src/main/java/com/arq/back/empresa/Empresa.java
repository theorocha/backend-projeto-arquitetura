package com.arq.back.empresa;

import com.arq.back.administrador.Administrador;
import com.arq.back.cliente.Cliente;
import com.arq.back.endereco.Endereco;
import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import com.arq.back.razaoencerramentoobra.RazaoEncerramentoObra;
import com.arq.back.servicoextra.ServicoExtra;
import com.arq.back.servicoprestado.ServicoPrestado;
import com.arq.back.setoratuacao.SetorAtuacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Nome da empresa", example = "1")
    private String nome;

    @NotNull
    @Schema(description = "CNPJ da empresa", example = "11414441/0001-98")
    private String cnpj;

    @Schema(description = "Telefone da empresa", example = "61999116902")
    private String telefone;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "endereco_id")
    @Schema(description = "Endereço da empresa", example = "Asa sul, 71890-329, Brasilia")
    private Endereco endereco;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "setor_atuacao_id")
    @Schema(description = "Setor de atuação da empresa", example = "Arquitetura e interiores")
    private SetorAtuacao setorAtuacao;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<ServicoExtra> servicosExtras = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<Administrador> administradores = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "empresas",fetch = FetchType.LAZY)
    private Set<Cliente> clientes = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServicoPrestado> servicosPrestados = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<OrcamentoContrato> orcamentos = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<RazaoEncerramentoObra> razaoEncerramentoObras = new HashSet<>();
}
