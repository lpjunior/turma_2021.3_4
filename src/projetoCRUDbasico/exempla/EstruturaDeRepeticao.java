package projetoCRUDbasico.exempla;

import java.util.*;

public class EstruturaDeRepeticao {

    public void estruturaFor(List<String> nomes) {
        for(int i = 0; i < nomes.size(); i++) {
            System.out.print(nomes.get(i));

            if(nomes.get(i).startsWith("Lu")) {
                System.out.println("O nome começa com Lu");
            }

            if(i != (nomes.size() - 1))
                System.out.print(", ");

            if(i == (nomes.size() - 1))
                System.out.println("\n");
        }
    }
    public void estruturaWhile(boolean test) {
        int i = 0;
        System.out.println("loop iniciado");
        while(true) { // loop infinito
            i++;
            if (i == 500000)
                test = true;

            if (test)
                break;
        }

        System.out.println("loop finalizado");
    }
    public void estruturaDoWhile() {
        var teclado = new Scanner(System.in);
        var contador = 0;

        do {
            System.out.print("Informe a senha: ");
            contador++;
        } while(!teclado.next().equals("Senha123@"));
        //while | do-while -> sempre precisa que a condição retorno true para continuar o loop

        teclado.close();
        System.out.println("Quantidade de tentativas: " + contador);
    }

    public void estruturaForEach(List<Integer> numeros) {
        Collections.sort(numeros);

        for(int numero : numeros) {
            System.out.print(numero + " ");
        }
    }

    public static void main(String[] args) {
        var edr = new EstruturaDeRepeticao();
        edr.estruturaFor(Arrays.asList("Luis", "Carlos Eduardo", "Antonio", "Carlos Rodrigo", "Ighor", "Joao", "Lucas", "Thawan", "Thiago", "Thaisa"));
        edr.estruturaWhile(false);
        edr.estruturaDoWhile();
        edr.estruturaForEach(Arrays.asList(30, 12, 4, 5, 8, 1, 697, 14, 2));
    }
}