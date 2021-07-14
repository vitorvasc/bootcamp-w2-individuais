package br.com.meli.diploma.bootcampspringdiploma.entity;

import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {
    @Test
    void whenStudentHasSubjectsAverageShouldCalculate() {
        // given
        StudentDTO studentDTO = new StudentDTO("Vitor Vasconcellos", List.of(
                new SubjectDTO("Matemática", 10),
                new SubjectDTO("Física I", 7),
                new SubjectDTO("Química III", 10)
        ));

        Student student = StudentDTO.convert(studentDTO);

        // exec
        double average = student.calculateAverage();

        // check
        assertEquals(9.0, average);
    }

    @Test
    void whenStudentHasNoSubjectsAverageShouldCalculateZero() {
        // given
        StudentDTO studentDTO = new StudentDTO("Vitor Vasconcellos", List.of());

        Student student = StudentDTO.convert(studentDTO);

        // exec
        double average = student.calculateAverage();

        // check
        assertEquals(0.0, average);
    }

    @Test
    void whenGivenStudentShouldGenerateDiploma() {
        // given
        StudentDTO studentDTO = new StudentDTO("Vitor Vasconcellos", List.of(
                new SubjectDTO("Matemática", 10),
                new SubjectDTO("Física I", 7),
                new SubjectDTO("Química III", 10)
        ));

        Student student = StudentDTO.convert(studentDTO);

        // exec
        Diploma diploma = student.writeDiploma();

        // check
        assertEquals("Vitor Vasconcellos", diploma.getStudent().getName());
        assertEquals(9.0, diploma.getAverage());
    }
}
