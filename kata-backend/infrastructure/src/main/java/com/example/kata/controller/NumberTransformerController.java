package com.example.kata.controller;

import com.example.kata.service.NumberTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Number transformer
 */
@RestController
@RequestMapping("/api/numbers")
public class NumberTransformerController {

    // dependency injection for NumberTransformerService
    @Autowired
    private NumberTransformerService transformerService;

    /**
     * trasform get endpoint
     * @param number
     * @return String
     */
    @GetMapping("/{number}")
    public ResponseEntity<?> transform(@PathVariable int number) {
        if (number < 0 || number > 100) {
            return ResponseEntity.badRequest().body("Le nombre doit être compris entre 0 et 100.");
        }
        return ResponseEntity.ok(transformerService.transformNumber(number));
    }
}
