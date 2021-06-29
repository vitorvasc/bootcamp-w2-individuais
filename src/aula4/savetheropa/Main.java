package aula4.savetheropa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRoupa guardaRoupa = new GuardaRoupa();

        List<Vestuario> vestuario1 = Arrays.asList(
                new Vestuario("Adidas", "Yeezy Boost"),
                new Vestuario("Adidas", "Calça"),
                new Vestuario("Adidas", "Camiseta")
        );

        List<Vestuario> vestuario2 = Arrays.asList(
                new Vestuario("Nike", "Air Jordan"),
                new Vestuario("Nike", "Calça de Moletom"),
                new Vestuario("Nike", "Jaqueta")
        );

        System.out.printf("\nRoupa armazenada no identificador %s\n", guardaRoupa.guardarVestuarios(vestuario1));
        System.out.printf("\nRoupa armazenada no identificador %s\n", guardaRoupa.guardarVestuarios(vestuario2));

        guardaRoupa.mostrarVestuarios();

        System.out.println("\nDevolvendo roupas armazenadas no identificador 1");
        List<Vestuario> roupasIdentificador1 = guardaRoupa.devolverVestuarios(0);
        roupasIdentificador1.forEach(System.out::println);

        System.out.println("\n\nDevolvendo roupas armazenadas no identificador 0");
        List<Vestuario> roupasIdentificador0 = guardaRoupa.devolverVestuarios(0);
        roupasIdentificador0.forEach(System.out::println);
    }
}
