package projetoCRUDbasico.app;

import projetoCRUDbasico.service.AlunoService;

import javax.swing.*;

public class AppFindById {
    public static void main(String[] args) {
        var service = new AlunoService();

        var alu = service.findById(1L);

        var msg = "Aluno.nome: " + alu.getNome() + "\n" + "Aluno.email: " + alu.getEmail() + "\n" + "Aluno.matricula: " + alu.getMatricula() + "\n" + "Aluno.sexo: " + alu.getSexo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}