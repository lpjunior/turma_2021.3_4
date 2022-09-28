package edu.rj.senac.gestaofuncionario.repository;

import edu.rj.senac.gestaofuncionario.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository("funcionarioRepository")
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    @Modifying
    @Transactional
    @Query(value = "update Funcionario f set f.email = :email where f.funcionarioId = :id")
    void updateEmail(UUID id, String email);

    Funcionario findByEmail(String email);
}
