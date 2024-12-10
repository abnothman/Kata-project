package com.example.kata.domain;

/**
 * Interface de port d'entree du service
 */
public interface NumberTransformer {
    /**
     * transform Number method
     * @param number
     * @return String
     */
    String transformNumber(int number);
}
