package br.com.meli.diploma.bootcampspringdiploma.entity;

import java.util.Date;

public class Diploma {
    private int id;
    private Aluno aluno;
    private double media;
    private String mensagem;

    public Diploma(int id, Aluno aluno, double media, String mensagem) {
        this.id = id;
        this.aluno = aluno;
        this.media = media;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
