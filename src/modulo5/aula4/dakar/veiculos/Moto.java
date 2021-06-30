package aula4.dakar.veiculos;

public class Moto extends Veiculo {

    public Moto() {
        super();
        this.peso = 300.00;
        this.rodas = 2;
    }

    public Moto(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa);
        this.peso = 300.00;
        this.rodas = 2;
    }
}
