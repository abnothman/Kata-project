package com.example.kata.controller;

import com.example.kata.domain.NumberTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing number transformations.
 */
@RestController
@RequestMapping("/api/numbers")
public class NumberTransformerController {

    private final NumberTransformer transformerService;

    /**
     * Constructor for dependency injection.
     *
     * @param transformerService the service handling number transformations.
     */
    @Autowired
    public NumberTransformerController(NumberTransformer transformerService) {
        this.transformerService = transformerService;
    }

    /**
     * GET endpoint to transform a number.
     *
     * @param number the number to transform.
     * @return the transformed number or an error message.
     */
    @GetMapping("/{number}")
    public ResponseEntity<String> transform(@PathVariable String number) {
        try {
            // Validation et transformation du nombre
            int numericValue = Integer.parseInt(number);

            if (numericValue < 0 || numericValue > 100) {
                return ResponseEntity.badRequest().body("Le nombre doit être compris entre 0 et 100.");
            }

            return ResponseEntity.ok(transformerService.transformNumber(numericValue));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("L'entrée fournie n'est pas un nombre valide.");
        }
    }
}