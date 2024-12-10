package com.example.kata.service;

import com.example.kata.domain.NumberTransformer;
import org.springframework.stereotype.Service;

/**
 * Service manage Number transformation
 */
@Service
public class NumberTransformerService implements NumberTransformer {

    /**
     * transformNumber service implementation
     * @param number
     * @return String
     */
    @Override
    public String transformNumber(int number) {
        // init
        StringBuilder result = new StringBuilder();

        // Vérification de divisibilité
        if (number % 3 == 0) result.append("FOO");
        if (number % 5 == 0) result.append("BAR");

        // Vérification des chiffres présents
        String numStr = String.valueOf(number);
        for (char c : numStr.toCharArray()) {
            if (c == '3') result.append("FOO");
            if (c == '5') result.append("BAR");
            if (c == '7') result.append("QUIX");
        }

        // Si aucune règle ne s'applique
        return result.length() > 0 ? result.toString() : numStr;
    }
}
