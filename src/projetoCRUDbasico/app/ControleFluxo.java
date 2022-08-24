package projetoCRUDbasico.app;

public class ControleFluxo {
    public static void main(String[] args) {
        int x = 10;
        int y = 100;
        
        for(int i = x; i < y; i++) {
            if(i % 2 == 0)
                continue; // salta o laço de repetição

            if(i == 75)
                break; // para o fluxo de repetição
            System.out.println("i = " + i);
        }

        // codigo
    }
}
