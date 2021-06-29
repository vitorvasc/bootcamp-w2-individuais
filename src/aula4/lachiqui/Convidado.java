package aula4.lachiqui;

public class Convidado {
    private String nome;
    private ConvidadoTipo tipo;

    public Convidado() {
    }

    public Convidado(String nome, ConvidadoTipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ConvidadoTipo getTipo() {
        return tipo;
    }

    public void setTipo(ConvidadoTipo tipo) {
        this.tipo = tipo;
    }

    public void gritar() {
        if (this.tipo.equals(ConvidadoTipo.MELI))
            System.out.println(this.nome + ": Viva la Chiqui !!");
    }
}
