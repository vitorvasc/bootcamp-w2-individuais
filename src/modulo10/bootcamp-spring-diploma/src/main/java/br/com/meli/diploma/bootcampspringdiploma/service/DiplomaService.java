package br.com.meli.diploma.bootcampspringdiploma.service;

import br.com.meli.diploma.bootcampspringdiploma.entity.Subject;
import br.com.meli.diploma.bootcampspringdiploma.repository.DiplomaRepository;
import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Diploma;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import br.com.meli.diploma.bootcampspringdiploma.exception.StudentAverageNotReached;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomaService {

    private final DiplomaRepository diplomaRepository;

    @Autowired
    public DiplomaService(DiplomaRepository diplomaRepository) {
        this.diplomaRepository = diplomaRepository;
    }

    public DiplomaDTO create(Student student) {
        double average = calculateAverage(student.getSubjects());

        if (average < 9.0)
            throw new StudentAverageNotReached("O estudante não atingiu a média mínima!");

        Diploma diploma = writeDiploma(student, average);

        diplomaRepository.add(diploma);

        return DiplomaDTO.convert(diploma);
    }

    public double calculateAverage(List<Subject> subjectList) {
        return subjectList.stream()
                .mapToDouble(Subject::getNote)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public Diploma writeDiploma(Student student, double average) {
        return new Diploma(
                diplomaRepository.getNextId(),
                student,
                average,
                "Sua média foi de " + average
        );
    }
}
