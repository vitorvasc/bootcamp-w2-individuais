package aula4.dakar.socorristas;

import aula4.dakar.veiculos.Veiculo;

public class SocorristaCarro extends Socorrista {

    @Override
    public void socorrer(Veiculo carro) {
        System.out.printf("Socorrendo carro %s\n", carro.getPlaca());
    }
}
