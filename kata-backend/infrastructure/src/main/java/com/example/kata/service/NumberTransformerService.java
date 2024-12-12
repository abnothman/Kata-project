package com.example.kata.service;

import com.example.kata.domain.NumberTransformer;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service for managing number transformations based on specific rules.
 */
@Service
public class NumberTransformerService implements NumberTransformer {

    // Règles pour la vérification des chiffres
    private static final Map<Integer, String> DIGIT_RULES = MapUtils.putAll(
            new java.util.HashMap<>(),
            new Object[][]{
                    {'3', "FOO"},
                    {'5', "BAR"},
                    {'7', "QUIX"}
            }
    );

    // Règles pour la divisibilité
    private static final Map<Integer, String> DIVISIBILITY_RULES = MapUtils.putAll(
            new java.util.HashMap<>(),
            new Object[][]{
                    {3, "FOO"},
                    {5, "BAR"}
            }
    );

    /**
     * Transforms a number according to divisibility and digit presence rules.
     *
     * @param number the number to transform.
     * @return the transformed string.
     */
    @Override
    public String transformNumber(int number) {
        // Initialisation du StringBuilder pour le résultat final.
        StringBuilder result = new StringBuilder();

        // Vérification des règles de divisibilité
        result.append(checkDivisibility(number));

        // Vérification des chiffres présents
        result.append(checkDigits(number));

        // Retourne le nombre si aucune règle ne s'applique
        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }

    /**
     * Vérifie les règles de divisibilité.
     */
    private String checkDivisibility(int number) {
        StringBuilder result = new StringBuilder();
        DIVISIBILITY_RULES.forEach((key, value) -> {
            if (number % key == 0) result.append(value);
        });
        return result.toString();
    }

    /**
     * Vérifie les règles basées sur les chiffres.
     */
    private String checkDigits(int number) {
        StringBuilder result = new StringBuilder();
        String numStr = String.valueOf(number);
        for (char c : numStr.toCharArray()) {
            result.append(DIGIT_RULES.getOrDefault(c, ""));
        }
        return result.toString();
    }
}