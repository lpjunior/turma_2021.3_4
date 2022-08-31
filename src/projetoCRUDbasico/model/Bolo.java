package projetoCRUDbasico.model;

import projetoCRUDbasico.model.enums.TipoBolo;

public class Bolo {
    private int qtdFarinha;
    private int qtdOvo;
    private int qtdOleo;
    private int qtdLeite;
    private int qtdAcucar;
    public TipoBolo tipoBolo;

    public Bolo(int qtdFarinha, int qtdOvo, int qtdOleo, int qtdLeite, int qtdAcucar) {
        this.qtdFarinha = qtdFarinha;
        this.qtdOvo = qtdOvo;
        this.qtdOleo = qtdOleo;
        this.qtdLeite = qtdLeite;
        this.qtdAcucar = qtdAcucar;
        this.tipoBolo = TipoBolo.COMUM;
    }

    public Bolo(int qtdFarinha, int qtdOvo, int qtdOleo, int qtdLeite, int qtdAcucar, TipoBolo tipoBolo) {
        this.qtdFarinha = qtdFarinha;
        this.qtdOvo = qtdOvo;
        this.qtdOleo = qtdOleo;
        this.qtdLeite = qtdLeite;
        this.qtdAcucar = qtdAcucar;
        this.tipoBolo = tipoBolo;
    }



    public static void main(String[] args) {
        var bolo1 = new Bolo(300, 2, 500, 2, 150);


        var bolo2 = new Bolo(300, 2, 500, 2, 150, TipoBolo.CHOCOLATE);
        var bolo3 = new Bolo(300, 2, 500, 2, 150, TipoBolo.LARANJA);
        var bolo4 = new Bolo(300, 2, 500, 2, 150, TipoBolo.CHOCOLATE);
        var bolo5 = new Bolo(300, 2, 500, 2, 150, TipoBolo.DOCE_DE_LEITE);
    }
}
// 300, 2, 500, 2, 150, true