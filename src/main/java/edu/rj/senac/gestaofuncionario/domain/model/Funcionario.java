package edu.rj.senac.gestaofuncionario.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.rj.senac.gestaofuncionario.domain.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "funcionario")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    // UUID - Identificador único universal (universally unique identifier)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID funcionarioId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(nullable = false)
    private String cpf;

    @ElementCollection
    @CollectionTable(name = "telefone", joinColumns = @JoinColumn(name = "funcionario_id", foreignKey = @ForeignKey(name = "fkey_funcionario_id")))
    @Column(name = "numero_telefone")
    private List<String> telefone;
}
