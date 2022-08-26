package projetoCRUDbasico.model;

import projetoCRUDbasico.model.Aluno;

public class AlunoTecnico extends Aluno {

    private String especializacao;

    /*
    * this -> representa a classe corrente "aberta"
    * super -> representa membro da classe pai (só funciona com herança)
    * */
    @Override
    public String getNome() {
        return "Aluno curso técnico: " + nome;
    }


    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
