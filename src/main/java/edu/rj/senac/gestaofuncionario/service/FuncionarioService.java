package edu.rj.senac.gestaofuncionario.service;

import edu.rj.senac.gestaofuncionario.domain.model.Funcionario;
import edu.rj.senac.gestaofuncionario.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Funcionario findById(UUID id) {
        return funcionarioRepository.findById(id).orElse(new Funcionario());
    }

    public void deleteById(UUID id) {
        funcionarioRepository.deleteById(id);
    }
}
