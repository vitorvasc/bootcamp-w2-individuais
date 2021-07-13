package br.com.meli.diploma.bootcampspringdiploma.exception;

public class StudentAverageNotReached extends RuntimeException {

    public StudentAverageNotReached(String message) {
        super(message);
    }
}
