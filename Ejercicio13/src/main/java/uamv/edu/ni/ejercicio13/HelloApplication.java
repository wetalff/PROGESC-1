package uamv.edu.ni.ejercicio13;

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

        Label lblTitle = new Label("Atención de clientes");

        TextField tfCliente = new TextField();
        tfCliente.setPromptText("Ingrese nombre del cliente");

        ArrayList<String> clientes = new ArrayList<>();

        Button btnAgregar = new Button("Agregar cliente");
        Button btnAtender = new Button("Atender cliente");
        Button btnSiguiente = new Button("Mostrar siguiente");
        Button btnCantidad = new Button("Mostrar cantidad");

        Label lblResultado = new Label("Resultado:");

        // Agregar cliente
        btnAgregar.setOnAction(event -> {

            String cliente = tfCliente.getText();

            clientes.add(cliente);

            lblResultado.setText(
                    "Cliente agregado: " + cliente
            );

            tfCliente.clear();
        });

        // Atender cliente
        btnAtender.setOnAction(event -> {

            if (!clientes.isEmpty()) {

                String cliente = clientes.get(0);

                clientes.remove(0);

                lblResultado.setText(
                        "Cliente atendido: " + cliente
                );

            } else {

                lblResultado.setText(
                        "No hay clientes para atender."
                );
            }
        });

        // Mostrar siguiente
        btnSiguiente.setOnAction(event -> {

            if (!clientes.isEmpty()) {

                String cliente = clientes.get(0);

                lblResultado.setText(
                        "Siguiente cliente: " + cliente
                );

            } else {

                lblResultado.setText(
                        "No hay clientes en espera."
                );
            }
        });

        // Mostrar cantidad
        btnCantidad.setOnAction(event -> {

            int cantidad = clientes.size();

            lblResultado.setText(
                    "Clientes en espera: " + cantidad
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfCliente,
                btnAgregar,
                btnAtender,
                btnSiguiente,
                btnCantidad,
                lblResultado
        );

        Scene scene = new Scene(root, 500, 350);

        stage.setTitle("Atención de clientes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}