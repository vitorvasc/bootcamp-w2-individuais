package br.com.meli.diploma.bootcampspringdiploma.controller;

import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import br.com.meli.diploma.bootcampspringdiploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DiplomaController {

    private DiplomaService service;

    @Autowired
    public DiplomaController(DiplomaService service) {
        this.service = service;
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<DiplomaDTO> create(@Valid @RequestBody StudentDTO studentDTO) {

        Student student = StudentDTO.convert(studentDTO);

        return new ResponseEntity<DiplomaDTO>(service.create(student), HttpStatus.CREATED);
    }
}
