package com.example.kata.domain;

/**
 * Interface représentant un transformateur de nombres.
 * Cette interface sert de port d'entrée pour les services qui appliquent des transformations
 * spécifiques sur des nombres entiers.
 */
public interface NumberTransformer {
    /**
     * Transforme un nombre entier en une représentation sous forme de chaîne.
     *
     * @param number le nombre entier à transformer.
     * @return la transformation du nombre sous forme de chaîne.
     */
    String transformNumber(int number);

}
