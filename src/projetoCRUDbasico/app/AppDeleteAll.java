package projetoCRUDbasico.app;

import projetoCRUDbasico.service.AlunoService;

import javax.swing.*;

public class AppDeleteAll {
    public static void main(String[] args) {
        var service = new AlunoService();
        var alunos = service.findByName("Luis");

        var status = service.deleteAll(alunos);

        var msg = "Status da exclusão: " + (status ? "Sucesso" : "Falha");
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}