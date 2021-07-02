package br.com.meli.bootcampspringpersonagens.repository;

import br.com.meli.bootcampspringpersonagens.entity.Personagem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    private static final File FILE = new File("src/main/resources/starwars.json");

    private final ObjectMapper mapper;

    @Autowired
    public PersonagemRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Personagem> getAll() {
        List<Personagem> personagens = new ArrayList<>();

        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Personagem>> typeReference = new TypeReference<List<Personagem>>() {};

            personagens = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personagens;
    }

    public List<Personagem> find(String name) {
        return getAll().stream()
                .filter(p -> p.getName().contains(name))
                .collect(Collectors.toList());
    }
}
