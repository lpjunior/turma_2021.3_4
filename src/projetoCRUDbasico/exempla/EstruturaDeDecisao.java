package projetoCRUDbasico.exempla;

public class EstruturaDeDecisao {

    public void estruturaSimples(String a) {
        /*
        * Equals -> faz um teste de comparação, porém é case sensitive
        * EqualsIgnoreCase -> faz um teste de comparação, ignorando o caso
        * */
        if(a.equalsIgnoreCase("Java")) {
            System.out.println("Estamos trabalhando com Java");
        }
        // code
    }

    public void estruturaComposta(String a) {
        if(a.equalsIgnoreCase("Java")) {
            System.out.println("Estamos trabalhando com Java");
        } else {
            System.out.println("Não é a linguagem atual de estudo");
        }
    }

    public void estruturaEncadeada(String a) {
        if(a.equalsIgnoreCase("PHP")) {
            System.out.println("Linguagem voltada para web comumente usada para aplicações simples");
        } else if(a.equalsIgnoreCase("MySQL")) {
            System.out.println("SBGD muito utilizado para aprendizagem de banco de dados");
        } else if(a.equals("Angular")) {
            System.out.println("Framework javascript para aplicações frontend");
        } else if(a.equals("Java")) {
            System.out.println("Linguagem voltada para qualquer tipo de plataforma, muito utilizada por empresas para aplicações de grande porte");
        } else { // O else é opcional em estrutura de decisão encadeada
            System.out.println("Opção invalida");
        }
    }

    public void estruturaTernario(String a) {
        System.out.println(a.equals("Java") ? "Linguagem Top" : "Xiii não é muito boa não!");
    }

    public void estruturaCompacta(String a) {
        if(a.equals("Java"))
            System.out.println("Linguagem simples de aprender");
        else
            System.out.println("Pode até ser mais que o Java, mais com muito mais gambis");
    }

    public static void main(String[] args) {
        var edd = new EstruturaDeDecisao();
        edd.estruturaSimples("java");
        edd.estruturaComposta("PHP");
        edd.estruturaEncadeada("Ruby");
        edd.estruturaTernario("Java");
        edd.estruturaCompacta("Java");
    }
}
