package uamv.edu.ni.ejericicio18;

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

        Label lblTitle = new Label("Sistema de atención de clientes");

        TextField tfCliente = new TextField();
        tfCliente.setPromptText("Nombre del cliente");

        // Cola de clientes pendientes
        ArrayList<String> cola = new ArrayList<>();

        // Lista que guarda el historial de clientes atendidos
        ArrayList<String> historial = new ArrayList<>();

        // Número del turno
        int[] numeroTurno = {1};

        Button btnRegistrar = new Button("Registrar cliente");
        Button btnAsignar = new Button("Asignar turno");
        Button btnAtender = new Button("Atender cliente");
        Button btnHistorial = new Button("Mostrar historial");
        Button btnPendientes = new Button("Mostrar clientes pendientes");

        Label lblResultado = new Label("Resultado:");

        // Registrar cliente
        btnRegistrar.setOnAction(event -> {

            String cliente = tfCliente.getText();

            cola.add(cliente);

            lblResultado.setText(
                    "Cliente registrado: " + cliente
            );

            tfCliente.clear();
        });

        // Asignar turno
        btnAsignar.setOnAction(event -> {

            if (!cola.isEmpty()) {

                String cliente = cola.get(cola.size() - 1);

                String turno = "T" + String.format("%03d", numeroTurno[0]);

                numeroTurno[0]++;

                cola.set(
                        cola.size() - 1,
                        cliente + " - " + turno
                );

                lblResultado.setText(
                        "Turno asignado a " + cliente + ": " + turno
                );

            } else {

                lblResultado.setText(
                        "No hay clientes registrados."
                );
            }
        });

        // Atender cliente
        btnAtender.setOnAction(event -> {

            if (!cola.isEmpty()) {

                String cliente = cola.get(0);

                cola.remove(0);

                historial.add(cliente);

                lblResultado.setText(
                        "Cliente atendido: " + cliente
                );

            } else {

                lblResultado.setText(
                        "No hay clientes pendientes."
                );
            }
        });

        // Mostrar historial
        btnHistorial.setOnAction(event -> {

            if (!historial.isEmpty()) {

                lblResultado.setText(
                        "Historial: " + historial
                );

            } else {

                lblResultado.setText(
                        "No hay clientes atendidos."
                );
            }
        });

        // Mostrar clientes pendientes
        btnPendientes.setOnAction(event -> {

            if (!cola.isEmpty()) {

                lblResultado.setText(
                        "Clientes pendientes: " + cola
                );

            } else {

                lblResultado.setText(
                        "No hay clientes pendientes."
                );
            }
        });

        root.getChildren().addAll(
                lblTitle,
                tfCliente,
                btnRegistrar,
                btnAsignar,
                btnAtender,
                btnHistorial,
                btnPendientes,
                lblResultado
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Sistema de clientes");
        stage.setScene(scene);
        stage.show();
    }

   
}