package com.example.kata.controller;

import com.example.infrastructure.InfrastructureApplication;
import com.example.kata.domain.NumberTransformer;
import com.example.kata.service.NumberTransformerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = NumberTransformerController.class)
@AutoConfigureMockMvc
public class NumberTransformerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberTransformerService numberTransformer;

    /**
     * test number transformer
     */
    @Test
    void testTransformNumberEndpoint() throws Exception {
        // When
        Mockito.when(numberTransformer.transformNumber(15)).thenReturn("FOOBAR");

        // Then
        mockMvc.perform(get("/api/numbers/15"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOOBAR"));
    }

    /**
     * test number out of range then throw illegalArgument Exception
     */
    @Test
    void testOutOfRangeNumber() throws Exception {
        mockMvc.perform(get("/api/numbers/101"))
                .andExpect(status().isBadRequest()) // Vérifie le code de statut
                .andExpect(content().string("Le nombre doit être compris entre 0 et 100."));
    }

}
