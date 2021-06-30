package aula4.dakar;

import aula4.dakar.veiculos.Carro;
import aula4.dakar.veiculos.Veiculo;

public class Main {
    public static void main(String[] args) {
        Corrida corrida = new Corrida();
        corrida.setQuantidadeVeiculosPermitidos(10);

        Carro carro1 = new Carro(100.0, 50.0, 25.0, "BBB-0023");
        Carro carro2 = new Carro(200.0, 100.0, 50.0, "XYZ-7497");
        Carro carro3 = new Carro(10.0, 10.0, 10.0, "AAA-0001");

        corrida.registrarCarro(carro1);
        corrida.registrarCarro(carro2);
        corrida.registrarCarro(carro3);

        corrida.socorrerCarro("AAA-0001");

        corrida.removerVeiculoPorPlaca("XYZ-7497");

        Veiculo vencedor = corrida.definirVencedor();

        System.out.println("Vencedor: " + vencedor.getPlaca());
    }
}
