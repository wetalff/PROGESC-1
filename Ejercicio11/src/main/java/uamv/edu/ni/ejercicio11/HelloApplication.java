package uamv.edu.ni.ejercicio11;

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

        Label lblTitle = new Label("Verificador de paréntesis");

        TextField tfExpresion = new TextField();
        tfExpresion.setPromptText("Ingrese una expresión");

        Button btnVerificar = new Button("Verificar");

        Label lblResultado = new Label("Resultado:");

        ArrayList<Character> pila = new ArrayList<>();

        btnVerificar.setOnAction(event -> {

            String expresion = tfExpresion.getText();

            pila.clear();

            boolean correcto = true;

            for (int i = 0; i < expresion.length(); i++) {

                char caracter = expresion.charAt(i);

                if (caracter == '(') {

                    pila.add(caracter);

                } else if (caracter == ')') {

                    if (!pila.isEmpty()) {

                        pila.remove(pila.size() - 1);

                    } else {

                        correcto = false;
                        break;
                    }
                }
            }

            if (correcto && pila.isEmpty()) {

                lblResultado.setText(
                        "Los paréntesis están correctamente balanceados."
                );

            } else {

                lblResultado.setText(
                        "Los paréntesis NO están correctamente balanceados."
                );
            }
        });

        root.getChildren().addAll(
                lblTitle,
                tfExpresion,
                btnVerificar,
                lblResultado
        );

        Scene scene = new Scene(root, 600, 300);

        stage.setTitle("Verificador de paréntesis");
        stage.setScene(scene);
        stage.show();
    }


}