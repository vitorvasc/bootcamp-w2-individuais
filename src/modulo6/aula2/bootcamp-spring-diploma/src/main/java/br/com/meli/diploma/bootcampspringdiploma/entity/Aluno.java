package br.com.meli.diploma.bootcampspringdiploma.entity;

import java.util.List;

public class Aluno {
    private String nome;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double calcularMedia() {
        return this.disciplinas.stream()
                .mapToDouble(Disciplina::getNota)
                .average()
                .orElse(0.0);
    }
}
