package com.exam.radius.service;

import com.exam.radius.model.RadiusCalculationResult;


public class RadiusCalculatorService {

    public RadiusCalculationResult calculateRadius(double g, double f, double c) {
        double discriminant = (g * g) + (f * f) - c;

        if (discriminant < 0) {
            return RadiusCalculationResult.error(
                    g, f, c, discriminant,
                    String.format("Invalid Circle: (g² + f² - c = %.4f) is negative. Circle is imaginary.", discriminant)
            );
        } else if (Math.abs(discriminant) < 1e-9) {
            return RadiusCalculationResult.success(g, f, c, discriminant, 0.0);
        } else {
            double radius = Math.sqrt(discriminant);
            return RadiusCalculationResult.success(g, f, c, discriminant, radius);
        }
    }


    public double parseInput(String input, String fieldName) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid number (e.g. 3 or -2.5).");
        }
    }
}
