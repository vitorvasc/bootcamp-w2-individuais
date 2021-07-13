package br.com.meli.diploma.bootcampspringdiploma.entity;

import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;

public class Subject {
    private String nome;
    private int note;

    public Subject(String name, int note) {
        this.nome = name;
        this.note = note;
    }

    public Subject(SubjectDTO subjectDTO) {
        this.nome = subjectDTO.getName();
        this.note = subjectDTO.getNote();
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
