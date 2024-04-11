package com.arq.back.cliente;

import com.arq.back.empresa.Empresa;
import com.arq.back.endereco.Endereco;
import com.arq.back.orcamentoecontrato.OrcamentoContrato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único", example = "1")
    private Long id;

    @Column(unique = true,length = 11)
    @Schema(description = "CPF do cliente", example = "12345634567")
    private Long cpf;

    @NotNull
    @Schema(description = "Nome do cliente", example = "João Silva")
    private String nome;

    @NotNull
    @Schema(description = "Email do cliente", example = "Joãosilva@gmail.com")
    private String email;

    @NotNull
    @Schema(description = "Celular do cliente", example = "61999116902")
    private String celular;

    @NotNull
    @Schema(description = "Senha do cliente", example = "senha123")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    @NotNull
    private Endereco endereco;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_empresa",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "empresa_id"))
    private Set<Empresa> empresas = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<OrcamentoContrato> orcamentos = new HashSet<>();
}
