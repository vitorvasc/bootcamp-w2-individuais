package br.com.meli.diploma.bootcampspringdiploma.entity;

import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.getName();
        this.subjects = studentDTO.getSubjects().stream()
                .map(Subject::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
