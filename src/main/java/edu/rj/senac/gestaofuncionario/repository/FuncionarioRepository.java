package edu.rj.senac.gestaofuncionario.repository;

import edu.rj.senac.gestaofuncionario.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("funcionarioRepository")
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
}
