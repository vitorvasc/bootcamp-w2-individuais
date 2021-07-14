package br.com.meli.diploma.bootcampspringdiploma.entity;

public class Diploma {

    private Student student;
    private double average;
    private String message;

    public Diploma(Student student, double average, String message) {
        this.student = student;
        this.average = average;
        this.message = message;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double media) {
        this.average = media;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
