package com.example.kata.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTransformerServiceTest {

    private NumberTransformerService numberTransformerService;

    @BeforeEach
    void setUp() {
        // Initialise le service avant chaque test
        numberTransformerService = new NumberTransformerService();
    }

    

    /**
     * Teste la transformation de 9.
     * Le résultat attendu est 'FOO'.
     */
    @Test
    void shouldReturnFOOWhenInputIs9() {
        String result = numberTransformerService.transformNumber(9);
        assertEquals("FOO", result, "Le résultat devrait être 'FOO'.");
    }

    /**
     * Teste la transformation de 5
     * Le résultat attendu est ''BARBAR'
     */
    @Test
    void shouldReturnBARBARWhenInputIs5() {
        String result = numberTransformerService.transformNumber(5);
        assertEquals("BARBAR", result, "Le résultat devrait être 'BARBAR'.");
    }

    /**
     * Teste la transformation de 15
     * Le résultat attendu est ''FOOBARBAR'
     */
    @Test
    void shouldReturnFOOBARBARWhenInputIs15() {
        String result = numberTransformerService.transformNumber(15);
        assertEquals("FOOBARBAR", result, "Le résultat devrait être 'FOOBARBAR'.");
    }

    /**
     * Teste la transformation de 3
     * Le résultat attendu est ''FOOFOO'
     */
    @Test
    void shouldReturnFOOFOOWhenInputIs3() {
        String result = numberTransformerService.transformNumber(3);
        assertEquals("FOOFOO", result, "Le résultat devrait être 'FOOFOO'.");
    }

    /**
     * Teste la transformation de 53
     * Le résultat attendu est ''BARFOO'
     */
    @Test
    void shouldReturnBARFOOWhenInputIs53() {
        String result = numberTransformerService.transformNumber(53);
        assertEquals("BARFOO", result, "Le résultat devrait être 'BARFOO'.");
    }

    /**
     * Teste la transformation de 51
     * Le résultat attendu est ''FOOBAR'
     */
    @Test
    void shouldReturnBARFOOWhenInputIs51() {
        String result = numberTransformerService.transformNumber(51);
        assertEquals("FOOBAR", result, "Le résultat devrait être 'FOOBAR'.");
    }

    /**
     * Teste la transformation de 33
     * Le résultat attendu est ''FOOFOOFOO'
     */
    @Test
    void shouldReturnBARFOOWhenInputIs33() {
        String result = numberTransformerService.transformNumber(33);
        assertEquals("FOOFOOFOO", result, "Le résultat devrait être 'FOOFOOFOO'.");
    }

    /**
     * Teste la transformation de 7
     * Le résultat attendu est ''QUIX'
     */
    @Test
    void shouldReturnQUIXWhenInputIs7() {
        String result = numberTransformerService.transformNumber(7);
        assertEquals("QUIX", result, "Le résultat devrait être 'QUIX'.");
    }

    // Test de cas où aucune transformation ne s'applique
    @Test
    void shouldReturnQUIXWhenInputIs1() {
        String result = numberTransformerService.transformNumber(1);
        assertEquals("1", result, "Le résultat devrait être '1'.");
    }
}