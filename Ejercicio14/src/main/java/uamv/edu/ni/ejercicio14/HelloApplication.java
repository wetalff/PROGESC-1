package uamv.edu.ni.ejercicio14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Label lblTitle = new Label("Sistema de turnos - Banco");

        ArrayList<String> turnos = new ArrayList<>();

        int[] numeroTurno = {1};

        Button btnGenerar = new Button("Generar turno");
        Button btnLlamar = new Button("Llamar turno");
        Button btnSiguiente = new Button("Mostrar siguiente");
        Button btnPendientes = new Button("Clientes pendientes");

        Label lblResultado = new Label("Resultado:");

        // Generar turno
        btnGenerar.setOnAction(event -> {

            String turno = "A" + String.format("%03d", numeroTurno[0]);

            turnos.add(turno);

            numeroTurno[0]++;

            lblResultado.setText(
                    "Turno generado: " + turno
            );
        });

        // Llamar turno
        btnLlamar.setOnAction(event -> {

            if (!turnos.isEmpty()) {

                String turno = turnos.get(0);

                turnos.remove(0);

                lblResultado.setText(
                        "Atendiendo turno: " + turno
                );

            } else {

                lblResultado.setText(
                        "No hay turnos pendientes."
                );
            }
        });

        // Mostrar siguiente
        btnSiguiente.setOnAction(event -> {

            if (!turnos.isEmpty()) {

                String siguiente = turnos.get(0);

                lblResultado.setText(
                        "Siguiente turno: " + siguiente
                );

            } else {

                lblResultado.setText(
                        "No hay turnos pendientes."
                );
            }
        });

        // Clientes pendientes
        btnPendientes.setOnAction(event -> {

            int cantidad = turnos.size();

            lblResultado.setText(
                    "Clientes pendientes: " + cantidad
            );
        });

        root.getChildren().addAll(
                lblTitle,
                btnGenerar,
                btnLlamar,
                btnSiguiente,
                btnPendientes,
                lblResultado
        );

        Scene scene = new Scene(root, 500, 350);

        stage.setTitle("Sistema de turnos");
        stage.setScene(scene);
        stage.show();
    }


}