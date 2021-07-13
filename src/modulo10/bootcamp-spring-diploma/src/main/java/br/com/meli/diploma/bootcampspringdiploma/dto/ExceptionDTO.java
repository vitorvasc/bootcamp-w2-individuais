package br.com.meli.diploma.bootcampspringdiploma.dto;

public class ExceptionDTO {

    private String message;
    private int status;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public ExceptionDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
