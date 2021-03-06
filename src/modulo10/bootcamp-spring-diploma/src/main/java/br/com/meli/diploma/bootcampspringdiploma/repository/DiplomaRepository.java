package br.com.meli.diploma.bootcampspringdiploma.repository;


import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DiplomaRepository {
    private static final List<Diploma> diplomas = new ArrayList<>();

    public List<Diploma> getList() {
        return diplomas;
    }

    public void add(Diploma diploma) {
        diplomas.add(diploma);
    }
}
