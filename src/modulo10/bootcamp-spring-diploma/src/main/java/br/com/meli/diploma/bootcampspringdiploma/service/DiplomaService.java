package br.com.meli.diploma.bootcampspringdiploma.service;

import br.com.meli.diploma.bootcampspringdiploma.dao.DiplomaDAO;
import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DiplomaService {

    private DiplomaDAO dao;

    @Autowired
    public DiplomaService(DiplomaDAO dao) {
        this.dao = dao;
    }

    public DiplomaDTO create(StudentDTO studentDTO) {
        double average = studentDTO.getSubjects().stream()
                .mapToDouble(s -> SubjectDTO.convert(s).getNote())
                .average()
                .orElseThrow(RuntimeException::new);

        if (average < 9.0)
            throw new RuntimeException("Falha ao criar diploma! Média inferior a 9.0");

        Student student = new Student(
                studentDTO.getName(),
                studentDTO.getSubjects().stream()
                        .map(SubjectDTO::convert)
                        .collect(Collectors.toList())
        );

        Diploma diploma = new Diploma(
                student,
                average,
                "Sua média foi de " + average
        );

        dao.add(diploma);

        return DiplomaDTO.convert(diploma);
    }
}
