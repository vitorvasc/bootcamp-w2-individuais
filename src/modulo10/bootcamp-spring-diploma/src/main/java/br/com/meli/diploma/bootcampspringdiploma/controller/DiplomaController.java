package br.com.meli.diploma.bootcampspringdiploma.controller;

import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<DiplomaDTO> view(@PathVariable int id) {
//        Diploma diploma = service.get(id);
        return new ResponseEntity<DiplomaDTO>(new DiplomaDTO(), HttpStatus.CREATED);

//        return new ResponseEntity<DiplomaDTO>(DiplomaDTO.converter(diploma), HttpStatus.OK);
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<DiplomaDTO> create(@Valid @RequestBody StudentDTO student) {
        System.out.println(student.getName());

        return new ResponseEntity<DiplomaDTO>(service.create(student), HttpStatus.CREATED);
    }
}
