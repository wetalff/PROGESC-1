package uamv.edu.ni.ejercicio8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();

        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Calculadora");

        TextField tfNumero1 = new TextField();
        tfNumero1.setPromptText("Primer número");

        TextField tfNumero2 = new TextField();
        tfNumero2.setPromptText("Segundo número");

        ArrayList<String> historial = new ArrayList<>();

        Button btnSuma = new Button("Suma");
        Button btnResta = new Button("Resta");
        Button btnMultiplicacion = new Button("Multiplicación");
        Button btnDivision = new Button("División");
        Button btnHistorial = new Button("Mostrar historial");

        Label lblResultado = new Label("Resultado:");

        // Suma
        btnSuma.setOnAction(event -> {

            double numero1 = Double.parseDouble(tfNumero1.getText());
            double numero2 = Double.parseDouble(tfNumero2.getText());

            double resultado = numero1 + numero2;

            historial.add(
                    numero1 + " + " + numero2 + " = " + resultado
            );

            lblResultado.setText("Resultado: " + resultado);
        });

        // Resta
        btnResta.setOnAction(event -> {

            double numero1 = Double.parseDouble(tfNumero1.getText());
            double numero2 = Double.parseDouble(tfNumero2.getText());

            double resultado = numero1 - numero2;

            historial.add(
                    numero1 + " - " + numero2 + " = " + resultado
            );

            lblResultado.setText("Resultado: " + resultado);
        });

        // Multiplicación
        btnMultiplicacion.setOnAction(event -> {

            double numero1 = Double.parseDouble(tfNumero1.getText());
            double numero2 = Double.parseDouble(tfNumero2.getText());

            double resultado = numero1 * numero2;

            historial.add(
                    numero1 + " * " + numero2 + " = " + resultado
            );

            lblResultado.setText("Resultado: " + resultado);
        });

        // División
        btnDivision.setOnAction(event -> {

            double numero1 = Double.parseDouble(tfNumero1.getText());
            double numero2 = Double.parseDouble(tfNumero2.getText());

            if (numero2 != 0) {

                double resultado = numero1 / numero2;

                historial.add(
                        numero1 + " / " + numero2 + " = " + resultado
                );

                lblResultado.setText("Resultado: " + resultado);

            } else {

                lblResultado.setText("No se puede dividir entre cero.");
            }
        });

        // Mostrar historial
        btnHistorial.setOnAction(event -> {

            lblResultado.setText(
                    "Historial: " + historial
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfNumero1,
                tfNumero2,
                btnSuma,
                btnResta,
                btnMultiplicacion,
                btnDivision,
                btnHistorial,
                lblResultado
        );

        Scene scene = new Scene(root, 600, 450);

        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    
}