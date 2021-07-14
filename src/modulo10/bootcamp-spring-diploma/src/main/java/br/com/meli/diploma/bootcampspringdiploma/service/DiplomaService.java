package br.com.meli.diploma.bootcampspringdiploma.service;

import br.com.meli.diploma.bootcampspringdiploma.repository.DiplomaRepository;
import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import br.com.meli.diploma.bootcampspringdiploma.exception.StudentAverageNotReached;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    private final DiplomaRepository diplomaRepository;

    @Autowired
    public DiplomaService(DiplomaRepository diplomaRepository) {
        this.diplomaRepository = diplomaRepository;
    }

    public DiplomaDTO create(Student student) {
        double average = student.calculateAverage();

        if (average < 9.0)
            throw new StudentAverageNotReached("O estudante não atingiu a média mínima!");

        Diploma diploma = student.writeDiploma();

        diplomaRepository.add(diploma);

        return DiplomaDTO.convert(diploma);
    }
}
