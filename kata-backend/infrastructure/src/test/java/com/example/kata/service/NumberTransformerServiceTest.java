package com.example.kata.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test for {@link NumberTransformerService}
 */
public class NumberTransformerServiceTest {
    // NumberTransformerService instance
    private final NumberTransformerService numberTransformerService = new NumberTransformerService();

    /**
     * test number division by three
     */
    @Test
    void testNumberDivisionByThree() {
        assertEquals("FOO", numberTransformerService.transformNumber(9));
    }

    /**
     * test number division by five
     */
    @Test
    void testNumberDivisionByFive() {
        assertEquals("BAR", numberTransformerService.transformNumber(10));
    }

    /**
     * test number contains three
     */
    @Test
    void testContainsThree() {
        assertEquals("FOO", numberTransformerService.transformNumber(13));
    }

    /**
     * test number contains five
     */
    @Test
    void testContainsFive() {
        assertEquals("BAR", numberTransformerService.transformNumber(59));
    }

    /**
     * test number contains seven
     */
    @Test
    void testContainsSeven() {
        assertEquals("QUIX", numberTransformerService.transformNumber(17));
    }

    /**
     * test complexe number
     */
    @Test
    void testComplexNumber() {
        assertEquals("FOOBARQUIXBAR", numberTransformerService.transformNumber(75));
    }

    /**
     * test no rules applied
     */
    @Test
    void testNoRulesApplied() {
        assertEquals("1", numberTransformerService.transformNumber(1));
    }
}
