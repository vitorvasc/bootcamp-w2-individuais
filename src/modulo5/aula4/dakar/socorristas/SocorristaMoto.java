package aula4.dakar.socorristas;

import aula4.dakar.veiculos.Veiculo;

public class SocorristaMoto extends Socorrista {

    @Override
    public void socorrer(Veiculo moto) {
        System.out.printf("Socorrendo moto %s\n", moto.getPlaca());
    }
}
