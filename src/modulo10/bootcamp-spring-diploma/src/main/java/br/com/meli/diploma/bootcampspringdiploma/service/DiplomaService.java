package br.com.meli.diploma.bootcampspringdiploma.service;

import br.com.meli.diploma.bootcampspringdiploma.dao.DiplomaDAO;
import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import br.com.meli.diploma.bootcampspringdiploma.exception.StudentAverageNotReached;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DiplomaService {

    private DiplomaDAO diplomaDAO;

    @Autowired
    public DiplomaService(DiplomaDAO diplomaDAO) {
        this.diplomaDAO = diplomaDAO;
    }

    public DiplomaDTO create(StudentDTO studentDTO) {
        double average = studentDTO.getSubjects().stream()
                .mapToDouble(s -> SubjectDTO.convert(s).getNote())
                .average()
                .orElseThrow(RuntimeException::new);

        if (average < 9.0)
            throw new StudentAverageNotReached("O estudante não atingiu a média mínima!");

        Student student = new Student(
                studentDTO.getName(),
                studentDTO.getSubjects().stream()
                        .map(SubjectDTO::convert)
                        .collect(Collectors.toList())
        );

        Diploma diploma = new Diploma(
                diplomaDAO.getNextId(),
                student,
                average,
                "Sua média foi de " + average
        );

        diplomaDAO.add(diploma);

        return DiplomaDTO.convert(diploma);
    }
}
