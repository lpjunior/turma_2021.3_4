package projetoCRUDbasico.app;
import projetoCRUDbasico.model.Aluno;

import javax.swing.*;
import java.util.Scanner;

// FQN "Full Qualified Name: projetoCRUDbasico.app.App
public class App {
    public static void main(String[] args) {
        Aluno alu; // referencia a classe Aluno
        alu = new Aluno(); // criando uma nova instancia e atribuindo o endereço de memória dessa instancia para a referencia

        /* Sistema
        * Entrada padrão: teclado
        * Saída padrão: monitor
        * */
        var teclado = new Scanner(System.in); // recurso que irá ler os dados digitados
        System.out.print("Informe o nome: ");
        alu.setNome(teclado.nextLine());

        System.out.print("Informe o email: ");
        alu.setEmail(teclado.next());

        System.out.print("Informe a matricula: ");
        alu.setMatricula(teclado.nextInt());

        System.out.print("Informe o sexo: ");
        alu.setSexo(teclado.next());

        teclado.close();

        System.out.println("Aluno.nome: " + alu.getNome());
        System.out.println("Aluno.email: " + alu.getEmail());
        System.out.println("Aluno.matricula: " + alu.getMatricula());
        System.out.println("Aluno.sexo: " + alu.getSexo());
    }
}