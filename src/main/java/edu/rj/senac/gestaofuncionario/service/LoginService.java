package edu.rj.senac.gestaofuncionario.service;

import edu.rj.senac.gestaofuncionario.domain.model.Login;
import edu.rj.senac.gestaofuncionario.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

   public Login save(Login login) {
        return loginRepository.save(login);
   }

    public void deleteById(UUID id) {
        loginRepository.deleteById(id);
    }

    public String login(Login login) {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.cThIIoDvwdueQB468K5xDc5633seEFoqwxjF_xSJyQQ";
    }

    public void logoff(UUID id) {
    }

    public void active(UUID id) {
    }

    public void disable(UUID id) {
    }
}
