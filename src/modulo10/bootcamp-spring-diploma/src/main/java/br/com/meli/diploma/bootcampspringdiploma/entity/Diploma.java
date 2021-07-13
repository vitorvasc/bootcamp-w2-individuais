package br.com.meli.diploma.bootcampspringdiploma.entity;

public class Diploma {
    private Student aluno;
    private double media;
    private String mensagem;


    public Diploma(Student aluno, double media, String mensagem) {
        this.aluno = aluno;
        this.media = media;
        this.mensagem = mensagem;
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
