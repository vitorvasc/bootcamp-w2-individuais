package aula4.lachiqui;

public class Bolo {
    private boolean velasAcesas;

    public Bolo() {
        this.velasAcesas = true;
    }

    public void apagarVelas() {
        System.out.println("* as velas do bolo se apagam *");
        this.velasAcesas = false;
    }
}
