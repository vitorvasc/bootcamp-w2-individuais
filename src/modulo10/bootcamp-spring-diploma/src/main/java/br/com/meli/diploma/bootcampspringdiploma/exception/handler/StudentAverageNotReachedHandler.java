package br.com.meli.diploma.bootcampspringdiploma.exception.handler;

import br.com.meli.diploma.bootcampspringdiploma.dto.ExceptionDTO;
import br.com.meli.diploma.bootcampspringdiploma.exception.StudentAverageNotReached;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentAverageNotReachedHandler {

    @ExceptionHandler(StudentAverageNotReached.class)
    public ResponseEntity<?> defaultHandler(StudentAverageNotReached e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }
}
