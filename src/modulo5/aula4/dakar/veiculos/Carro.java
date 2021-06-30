package aula4.dakar.veiculos;

public class Carro extends Veiculo {

    public Carro() {
        super();
        this.peso = 1_000.00;
        this.rodas = 4;
    }

    public Carro(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa);
        this.peso = 1_000.00;
        this.rodas = 4;
    }
}
