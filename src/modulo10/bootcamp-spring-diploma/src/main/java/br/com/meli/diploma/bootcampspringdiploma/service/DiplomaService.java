package br.com.meli.diploma.bootcampspringdiploma.service;

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

    public DiplomaDTO create(StudentDTO studentDTO) {
        double average = calculateAverage(studentDTO.getSubjects());

        if (average < 9.0)
            throw new StudentAverageNotReached("O estudante não atingiu a média mínima!");

        Student student = StudentDTO.convert(studentDTO);

        Diploma diploma = writeDiploma(student, average);

        diplomaRepository.add(diploma);

        return DiplomaDTO.convert(diploma);
    }

    public double calculateAverage(List<SubjectDTO> subjectDTOList) {
        return subjectDTOList.stream()
                .mapToDouble(s -> SubjectDTO.convert(s).getNote())
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
