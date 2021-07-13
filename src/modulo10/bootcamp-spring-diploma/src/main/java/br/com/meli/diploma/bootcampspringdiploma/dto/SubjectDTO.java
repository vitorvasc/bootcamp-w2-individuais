package br.com.meli.diploma.bootcampspringdiploma.dto;

import br.com.meli.diploma.bootcampspringdiploma.entity.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SubjectDTO {

    @NotNull(message = "O nome deve ser válido.")
    @Size(min = 8, max = 50, message = "O tamanho do nome deve estar entre 8 e 50 caracteres.")
    @Pattern(regexp = "[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\\s]+", message = "O nome possui caracteres inválidos.")
    @JsonProperty("subject")
    private String name;

    @NotNull(message = "A nota deve ser válida.")
    @Range(min = 1, max = 10, message = "A nota deve estar entre 1 e 10.")
    private int note;

    public SubjectDTO(String name, int note) {
        this.name = name;
        this.note = note;
    }

    public SubjectDTO(Subject subject) {
        this.name = subject.getName();
        this.note = subject.getNote();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public static SubjectDTO convert(Subject subject) {
        return new SubjectDTO(subject);
    }

    public static Subject convert(SubjectDTO subjectDTO) {
        return new Subject(subjectDTO);
    }
}
