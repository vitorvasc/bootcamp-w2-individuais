package br.com.meli.bootcampspringpersonagens.controller;

import br.com.meli.bootcampspringpersonagens.entity.Personagem;
import br.com.meli.bootcampspringpersonagens.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;

    @Autowired
    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<Personagem> getAll() {
        return repository.getAll();
    }

    @GetMapping("/{name}")
    public List<Personagem> getByName(@PathVariable String name) {
        return repository.find(name);
    }
}
