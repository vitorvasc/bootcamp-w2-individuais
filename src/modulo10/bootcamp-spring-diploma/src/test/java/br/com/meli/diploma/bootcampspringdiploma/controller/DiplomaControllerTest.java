package br.com.meli.diploma.bootcampspringdiploma.controller;

import br.com.meli.diploma.bootcampspringdiploma.dto.StudentDTO;
import br.com.meli.diploma.bootcampspringdiploma.dto.SubjectDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class DiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void whenGivenStudentDTOShouldAnalyzeNotes() throws Exception {
        StudentDTO studentDTO = new StudentDTO("Vitor Vasconcellos", List.of(
                new SubjectDTO("Matemática", 10),
                new SubjectDTO("Física I", 10),
                new SubjectDTO("Química III", 10)
        ));

        String payload = mapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated());
    }
}
