package uamv.edu.ni.ejercicio10;

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

        Label lblTitle = new Label("Sistema Deshacer");

        TextField tfOperacion = new TextField();
        tfOperacion.setPromptText("Ingrese una operación");

        ArrayList<String> pila = new ArrayList<>();

        Button btnGuardar = new Button("Guardar operación");
        Button btnDeshacer = new Button("Deshacer última operación");
        Button btnActual = new Button("Mostrar operación actual");

        Label lblResultado = new Label("Resultado:");

        // GUARDAR OPERACIÓN
        btnGuardar.setOnAction(event -> {

            String operacion = tfOperacion.getText();

            pila.add(operacion);

            lblResultado.setText(
                    "Operación guardada: " + operacion
            );

            tfOperacion.clear();
        });

        // DESHACER ÚLTIMA OPERACIÓN
        btnDeshacer.setOnAction(event -> {

            if (!pila.isEmpty()) {

                int posicion = pila.size() - 1;

                String operacion = pila.get(posicion);

                pila.remove(posicion);

                lblResultado.setText(
                        "Operación deshecha: " + operacion
                );

            } else {

                lblResultado.setText(
                        "No hay operaciones para deshacer."
                );
            }
        });

        // MOSTRAR OPERACIÓN ACTUAL
        btnActual.setOnAction(event -> {

            if (!pila.isEmpty()) {

                int posicion = pila.size() - 1;

                String operacion = pila.get(posicion);

                lblResultado.setText(
                        "Operación actual: " + operacion
                );

            } else {

                lblResultado.setText(
                        "No hay operaciones."
                );
            }
        });

        root.getChildren().addAll(
                lblTitle,
                tfOperacion,
                btnGuardar,
                btnDeshacer,
                btnActual,
                lblResultado
        );

        Scene scene = new Scene(root, 500, 350);

        stage.setTitle("Sistema Deshacer");
        stage.setScene(scene);
        stage.show();
    }

 
}