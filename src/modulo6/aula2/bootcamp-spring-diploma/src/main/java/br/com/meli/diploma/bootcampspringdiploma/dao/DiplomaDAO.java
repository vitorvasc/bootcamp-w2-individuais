package br.com.meli.diploma.bootcampspringdiploma.dao;


import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DiplomaDAO {
    private static final List<Diploma> diplomas = new ArrayList<>();

    public List<Diploma> getList() {
        return diplomas;
    }

    public void add(Diploma diploma) {
        diplomas.add(diploma);
    }

    public Diploma get(int id) {
        Optional<Diploma> diplomaOptional = diplomas.stream()
                .filter(d -> d.getId() == id)
                .findFirst();

        return diplomaOptional.orElse(null);
    }

    public int getNextId() {
        return diplomas.size() + 1;
    }
}
