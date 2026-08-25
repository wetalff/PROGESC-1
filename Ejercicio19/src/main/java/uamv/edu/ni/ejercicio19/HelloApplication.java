package uamv.edu.ni.ejercicio19;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

        Label lblTitle = new Label("Editor de texto");

        TextArea txtEditor = new TextArea();
        txtEditor.setPromptText("Escriba aquí...");

        ArrayList<String> pilaDeshacer = new ArrayList<>();
        ArrayList<String> pilaRehacer = new ArrayList<>();

        Button btnGuardar = new Button("Guardar cambio");
        Button btnDeshacer = new Button("Deshacer");
        Button btnRehacer = new Button("Rehacer");
        Button btnEstado = new Button("Mostrar estado actual");

        Label lblResultado = new Label("Resultado:");

        // Guardar cambio
        btnGuardar.setOnAction(event -> {

            pilaDeshacer.add(txtEditor.getText());

            // Al hacer un nuevo cambio se limpia la pila de rehacer
            pilaRehacer.clear();

            lblResultado.setText(
                    "Cambio guardado."
            );
        });

        // Deshacer
        btnDeshacer.setOnAction(event -> {

            if (!pilaDeshacer.isEmpty()) {

                // Guardamos el estado actual para poder rehacerlo
                pilaRehacer.add(txtEditor.getText());

                int posicion = pilaDeshacer.size() - 1;

                String estadoAnterior =
                        pilaDeshacer.get(posicion);

                txtEditor.setText(estadoAnterior);

                pilaDeshacer.remove(posicion);

                lblResultado.setText(
                        "Cambio deshecho."
                );

            } else {

                lblResultado.setText(
                        "No hay cambios para deshacer."
                );
            }
        });

        // Rehacer
        btnRehacer.setOnAction(event -> {

            if (!pilaRehacer.isEmpty()) {

                // Guardamos el estado actual en deshacer
                pilaDeshacer.add(txtEditor.getText());

                int posicion = pilaRehacer.size() - 1;

                String estadoSiguiente =
                        pilaRehacer.get(posicion);

                txtEditor.setText(estadoSiguiente);

                pilaRehacer.remove(posicion);

                lblResultado.setText(
                        "Cambio rehecho."
                );

            } else {

                lblResultado.setText(
                        "No hay cambios para rehacer."
                );
            }
        });

        // Mostrar estado actual
        btnEstado.setOnAction(event -> {

            lblResultado.setText(
                    "Estado actual: " + txtEditor.getText()
            );
        });

        root.getChildren().addAll(
                lblTitle,
                txtEditor,
                btnGuardar,
                btnDeshacer,
                btnRehacer,
                btnEstado,
                lblResultado
        );

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("Editor con Deshacer y Rehacer");
        stage.setScene(scene);
        stage.show();
    }

   
}