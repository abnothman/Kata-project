package com.example.kata.controller;

import com.example.kata.domain.NumberTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NumberTransformerController.class)
public class NumberTransformerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberTransformer transformerService;

    @BeforeEach
    void setUp() {
        // Setup des comportements par défaut pour le service mocké
        when(transformerService.transformNumber(3)).thenReturn("FOO");
        when(transformerService.transformNumber(5)).thenReturn("BARBAR");
        when(transformerService.transformNumber(15)).thenReturn("FOOBAR");
    }

    /**
     * GET endpoint to transform a number when ok
     * @throws Exception
     */
    @Test
    void testTransformValidNumber() throws Exception {
        mockMvc.perform(get("/api/numbers/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOO"));
    }

    /**
     * GET endpoint to transform a number when bad request
     * @throws Exception
     */
    @Test
    void testTransformNumberOutOfBounds() throws Exception {
        mockMvc.perform(get("/api/numbers/101"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Le nombre doit être compris entre 0 et 100."));
    }

    /**
     * GET endpoint to transform a number when invalid number format
     * @throws Exception
     */
    @Test
    void testTransformNonNumericInput() throws Exception {
        mockMvc.perform(get("/api/numbers/abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("L'entrée fournie n'est pas un nombre valide."));
    }
}