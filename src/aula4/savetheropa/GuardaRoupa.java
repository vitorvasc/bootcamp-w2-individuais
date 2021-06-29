package aula4.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRoupa {
    static int contador = 0;

    private Map<Integer, List<Vestuario>> roupas = new HashMap<>();

    public Integer guardarVestuarios(List<Vestuario> listaDeVestuario) {
        int identificador = contador;
        roupas.put(identificador, listaDeVestuario);

        contador++;

        return identificador;
    }

    public void mostrarVestuarios() {
        System.out.println("\nLista de vestuários armazenados:");
        for (int i = 0; i < roupas.size(); i++) {
            System.out.printf("\nIdentificador: %s\n", i);
            roupas.get(i).forEach(System.out::println);
        }
    }

    public List<Vestuario> devolverVestuarios(Integer id) {
        return roupas.get(id);
    }
}
