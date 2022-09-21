package edu.rj.senac.gestaofuncionario.service;

import edu.rj.senac.gestaofuncionario.domain.model.Funcionario;
import edu.rj.senac.gestaofuncionario.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

   public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
   }

   public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
   }
}
