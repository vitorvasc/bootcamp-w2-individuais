package aula4.lachiqui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Convidado> convidados = Arrays.asList(
                new Convidado("Vitor", ConvidadoTipo.MELI),
                new Convidado("João", ConvidadoTipo.STANDARD),
                new Convidado("Márcia", ConvidadoTipo.STANDARD),
                new Convidado("Antônio", ConvidadoTipo.MELI),
                new Convidado("Tobias", ConvidadoTipo.MELI),
                new Convidado("Cássio", ConvidadoTipo.STANDARD)
        );

        List<List<FogosArtificio>> pacoteFogos = new ArrayList<>();

        List<FogosArtificio> fogos1 = Arrays.asList(
                new FogosArtificio("Kabum"),
                new FogosArtificio("Pew pew")
        );

        List<FogosArtificio> fogos2 = Collections.singletonList(
                new FogosArtificio("Pow, pow, pow!")
        );

        pacoteFogos.add(fogos1);
        pacoteFogos.add(fogos2);

        Bolo bolo = new Bolo();

        bolo.apagarVelas();

        for (List<FogosArtificio> fogos : pacoteFogos) {
            for (FogosArtificio f : fogos) {
                f.explodir();
            }
        }

        for (Convidado c : convidados) {
            c.gritar();
        }

    }
}
