package br.com.meli.diploma.bootcampspringdiploma.dto;

import br.com.meli.diploma.bootcampspringdiploma.entity.Aluno;
import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;

public class DiplomaDTO {
    private String aluno;
    private double media;
    private String mensagem;

    public DiplomaDTO(String aluno, double media, String mensagem) {
        this.aluno = aluno;
        this.media = media;
        this.mensagem = mensagem;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
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

    public static DiplomaDTO converter(Diploma diploma) {
        return new DiplomaDTO(diploma.getAluno().getNome(), diploma.getMedia(), diploma.getMensagem());
    }
}
