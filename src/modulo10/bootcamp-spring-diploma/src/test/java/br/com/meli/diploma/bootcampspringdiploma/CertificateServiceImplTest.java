package br.com.meli.diploma.bootcampspringdiploma;

import br.com.meli.diploma.bootcampspringdiploma.dto.DiplomaDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import br.com.meli.diploma.bootcampspringdiploma.entity.Student;
import br.com.meli.diploma.bootcampspringdiploma.repository.DiplomaRepository;
import br.com.meli.diploma.bootcampspringdiploma.service.DiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CertificateServiceImplTest {

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

        // expected
        DiplomaDTO diplomaDTO = new DiplomaDTO(
                "Sua média foi de 10.0",
                10,
                StudentDTO.convert(student)
        );

        // exec
        DiplomaDTO resultDiplomaDTO = diplomaService.create(student);

        // check
        assertEquals(diplomaDTO.getStudent().getName(), student.getName());
        assertEquals(diplomaDTO.getMessage(), resultDiplomaDTO.getMessage());
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
}
