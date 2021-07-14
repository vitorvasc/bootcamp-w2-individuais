package br.com.meli.diploma.bootcampspringdiploma.dto;

import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;

public class DiplomaDTO {

    private String message;
    private double average;
    private StudentDTO student;

    public DiplomaDTO(String message, double average, StudentDTO student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }

    public DiplomaDTO(Diploma diploma) {
        this.message = diploma.getMessage();
        this.average = diploma.getAverage();
        this.student = StudentDTO.convert(diploma.getStudent());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public static DiplomaDTO convert(Diploma diploma) {
        return new DiplomaDTO(diploma);
    }
}
