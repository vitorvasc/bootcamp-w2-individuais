package br.com.meli.diploma.bootcampspringdiploma.controller;

import br.com.meli.diploma.bootcampspringdiploma.dao.DiplomaDAO;
import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Aluno;
import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import br.com.meli.diploma.bootcampspringdiploma.entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    private DiplomaDAO dao;

    @Autowired
    public DiplomaController(DiplomaDAO diplomaDAO) {
        this.dao = diplomaDAO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiplomaDTO> view(@PathVariable int id) {
        Diploma diploma = dao.get(id);

        return new ResponseEntity<DiplomaDTO>(DiplomaDTO.converter(diploma), HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<?> create(@RequestBody Aluno aluno, UriComponentsBuilder uriBuilder) {
        double media = aluno.calcularMedia();
        if (media < 9.0)
            return new ResponseEntity<>("Falha ao criar diploma! Média inferior a 9.0", HttpStatus.OK);

        Diploma diploma = new Diploma(dao.getNextId(), aluno, media, "Parabéns!");
        dao.add(diploma);

        URI uri = uriBuilder.path("/diploma/{id}").buildAndExpand(diploma.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
