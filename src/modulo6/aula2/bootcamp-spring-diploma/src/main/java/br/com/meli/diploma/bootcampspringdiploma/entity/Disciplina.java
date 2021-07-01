package br.com.meli.diploma.bootcampspringdiploma.entity;

public class Disciplina {
    private String nome;
    private double nota;

    public Disciplina(String name, double nota) {
        this.nome = name;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
