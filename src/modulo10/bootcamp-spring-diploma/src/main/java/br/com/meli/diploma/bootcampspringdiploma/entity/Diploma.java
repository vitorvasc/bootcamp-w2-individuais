package br.com.meli.diploma.bootcampspringdiploma.entity;

public class Diploma {

    private int id;
    private Student aluno;
    private double media;
    private String mensagem;

    public Diploma(int id, Student aluno, double media, String mensagem) {
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

    public Student getAluno() {
        return aluno;
    }

    public void setAluno(Student aluno) {
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
