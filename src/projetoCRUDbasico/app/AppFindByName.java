package projetoCRUDbasico.app;

import projetoCRUDbasico.service.AlunoService;

import javax.swing.*;

public class AppFindByName {
    public static void main(String[] args) {
        var service = new AlunoService();

        var respostaList = service.findByName("Luis").stream().map(aluno -> "Aluno.nome: " + aluno.getNome() + "\n" + "Aluno.email: " + aluno.getEmail() + "\n" + "Aluno.matricula: " + aluno.getMatricula() + "\n" + "Aluno.sexo: " + aluno.getSexo() + "\n\n").toList();
        JOptionPane.showMessageDialog(null, respostaList, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}