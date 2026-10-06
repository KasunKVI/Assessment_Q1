package com.exam.radius.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RadiusCalculationResult {
    private final double g;
    private final double f;
    private final double c;
    private final double discriminant;
    private final double radius;
    private final boolean valid;
    private final String message;

    public static RadiusCalculationResult success(double g, double f, double c, double discriminant, double radius) {
        return new RadiusCalculationResult(g, f, c, discriminant, radius, true, "Success");
    }

    public static RadiusCalculationResult error(double g, double f, double c, double discriminant, String message) {
        return new RadiusCalculationResult(g, f, c, discriminant, 0.0, false, message);
    }

    public String getFormattedRadius() {
        if (!valid) {
            return "N/A";
        }
        return String.format("%.4f", radius);
    }
}
