package br.com.meli.diploma.bootcampspringdiploma.dto;

import br.com.meli.diploma.bootcampspringdiploma.entity.Student;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO {

    @NotNull(message = "O nome deve ser válido.")
    @Size(min = 8, max = 50, message = "O tamanho do nome deve estar entre 8 e 50 caracteres.")
    @Pattern(regexp = "[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\\s]+", message = "O nome possui caracteres inválidos.")
    private String name;

    @Valid
    private List<SubjectDTO> subjects;

    public StudentDTO(String name, List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public StudentDTO(Student student) {
        this.name = student.getNome();
        this.subjects = student.getDisciplinas().stream()
                .map(SubjectDTO::convert)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

    public static Student convert(StudentDTO studentDTO) {
        return new Student(studentDTO);
    }

    public static StudentDTO convert(Student student) {
        return new StudentDTO(student);
    }
}
