package projetoCRUDbasico.app;

import projetoCRUDbasico.model.Aluno;

import javax.swing.*;

// FQN "Full Qualified Name: projetoCRUDbasico.app.App
public class App {
    public static void main(String[] args) {
        Aluno alu; // referencia a classe Aluno
        alu = new Aluno(); // criando uma nova instancia e atribuindo o endereço de memória dessa instancia para a referencia

        /* Sistema
         * Entrada padrão: teclado
         * Saída padrão: monitor
         * */
        var nome = JOptionPane.showInputDialog(null, "Informe o nome: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        alu.setNome(nome);

        var email = JOptionPane.showInputDialog(null, "Informe o email: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        alu.setEmail(email);

        var matricula = JOptionPane.showInputDialog(null, "Informe a matricula: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        alu.setMatricula(Integer.parseInt(matricula));

        var sexo = JOptionPane.showInputDialog(null, "Informe o sexo: ", "Input Nome", JOptionPane.QUESTION_MESSAGE);
        alu.setSexo(sexo);

        var msg = "Aluno.nome: " + alu.getNome() + "\n" + "Aluno.email: " + alu.getEmail() + "\n" + "Aluno.matricula: " + alu.getMatricula() + "\n" + "Aluno.sexo: " + alu.getSexo();
        JOptionPane.showMessageDialog(null, msg, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
}