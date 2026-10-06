package com.exam.radius.controller;

import com.exam.radius.model.RadiusCalculationResult;
import com.exam.radius.service.RadiusCalculatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField txtG;

    @FXML
    private TextField txtF;

    @FXML
    private TextField txtC;

    @FXML
    private TextField txtRadius;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnClear;

    private final RadiusCalculatorService service = new RadiusCalculatorService();

    @FXML
    public void initialize() {
        lblStatus.setText("Enter values for g, f, and c to calculate radius.");
        txtRadius.setEditable(false);
    }

    @FXML
    void handleCalculate(ActionEvent event) {
        lblStatus.getStyleClass().removeAll("status-error", "status-success");

        try {
            double g = service.parseInput(txtG.getText(), "Constant 'g'");
            double f = service.parseInput(txtF.getText(), "Constant 'f'");
            double c = service.parseInput(txtC.getText(), "Constant 'c'");

            RadiusCalculationResult result = service.calculateRadius(g, f, c);

            if (result.isValid()) {
                txtRadius.setText(result.getFormattedRadius());
                lblStatus.setText(String.format("Calculated successfully! (g² + f² - c = %.2f)", result.getDiscriminant()));
                lblStatus.getStyleClass().add("status-success");
            } else {
                txtRadius.setText("Invalid");
                lblStatus.setText(result.getMessage());
                lblStatus.getStyleClass().add("status-error");
            }

        } catch (IllegalArgumentException ex) {
            txtRadius.setText("Error");
            lblStatus.setText(ex.getMessage());
            lblStatus.getStyleClass().add("status-error");
        }
    }

    @FXML
    void handleClear(ActionEvent event) {
        txtG.clear();
        txtF.clear();
        txtC.clear();
        txtRadius.clear();
        lblStatus.setText("Fields reset. Enter new parameters.");
        lblStatus.getStyleClass().removeAll("status-error", "status-success");
        txtG.requestFocus();
    }
}
