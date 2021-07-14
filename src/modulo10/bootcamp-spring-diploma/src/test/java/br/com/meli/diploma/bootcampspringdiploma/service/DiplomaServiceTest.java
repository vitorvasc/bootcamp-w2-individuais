package br.com.meli.diploma.bootcampspringdiploma.service;

import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import br.com.meli.diploma.bootcampspringdiploma.exception.StudentAverageNotReached;
import br.com.meli.diploma.bootcampspringdiploma.repository.DiplomaRepository;
import br.com.meli.diploma.bootcampspringdiploma.service.DiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DiplomaServiceTest {

    private DiplomaService diplomaService;
    private Validator validator;

    @BeforeEach
    void init() {
        // setup
        DiplomaRepository diplomaRepository = Mockito.mock(DiplomaRepository.class);
        diplomaService = new DiplomaService(diplomaRepository);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenStudentHasNameAndHasSubjectsShouldCreateDiploma() {
        // given
        StudentDTO studentDTO = new StudentDTO("Vitor Vasconcellos", List.of(
                new SubjectDTO("Matemática", 10),
                new SubjectDTO("Física I", 10),
                new SubjectDTO("Química III", 10)
        ));

        Student student = StudentDTO.convert(studentDTO);

        // exec
        DiplomaDTO resultDiplomaDTO = diplomaService.create(student);

        // check
        assertEquals("Vitor Vasconcellos", resultDiplomaDTO.getStudent().getName());
        assertEquals("Sua média foi de 10.0", resultDiplomaDTO.getMessage());
        assertEquals(10, resultDiplomaDTO.getAverage());
    }

    @Test
    void whenStudentHasEmptyNameAndHasSubjectsShouldNotValidate() {
        // given
        StudentDTO studentDTO = new StudentDTO("", List.of(
                new SubjectDTO("Matemática", 10),
                new SubjectDTO("Física I", 10),
                new SubjectDTO("Química III", 10)
        ));

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);
        assertFalse(violations.isEmpty());
    }

    @Test
    void whenStudentHasAverageBelowMinimumShouldThrowStudentAverageNotReached() {
        // given
        StudentDTO studentDTO = new StudentDTO("", List.of(
                new SubjectDTO("Matemática", 1),
                new SubjectDTO("Física I", 1),
                new SubjectDTO("Química III", 1)
        ));

        Student student = StudentDTO.convert(studentDTO);

        // check
        assertThrows(StudentAverageNotReached.class, () -> {
            diplomaService.create(student);
        });
    }
}
