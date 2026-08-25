package uamv.edu.ni.ejercicio5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

        Label lblTitle = new Label("Administración de estudiantes");

        TextField tfEstudiante = new TextField();
        tfEstudiante.setPromptText("Ingrese nombre del estudiante");

        ArrayList<String> estudiantes = new ArrayList<>();

        Button btnAgregar = new Button("Agregar estudiante");
        Button btnBuscar = new Button("Buscar estudiante");
        Button btnEliminar = new Button("Eliminar estudiante");
        Button btnCantidad = new Button("Mostrar cantidad");

        Label lblResultado = new Label("Resultado:");
        Label lblLista = new Label("Estudiantes:");

        // Agregar estudiante
        btnAgregar.setOnAction(event -> {

            String estudiante = tfEstudiante.getText();

            estudiantes.add(estudiante);

            lblResultado.setText("Estudiante agregado: " + estudiante);
            lblLista.setText("Estudiantes: " + estudiantes);

            tfEstudiante.clear();
        });

        // Buscar estudiante
        btnBuscar.setOnAction(event -> {

            String estudiante = tfEstudiante.getText();

            if (estudiantes.contains(estudiante)) {
                lblResultado.setText("El estudiante se encuentra en la lista.");
            } else {
                lblResultado.setText("El estudiante no se encuentra.");
            }
        });

        // Eliminar estudiante
        btnEliminar.setOnAction(event -> {

            String estudiante = tfEstudiante.getText();

            if (estudiantes.contains(estudiante)) {

                estudiantes.remove(estudiante);

                lblResultado.setText("Estudiante eliminado: " + estudiante);
                lblLista.setText("Estudiantes: " + estudiantes);

            } else {
                lblResultado.setText("El estudiante no se encuentra.");
            }

            tfEstudiante.clear();
        });

        // Mostrar cantidad
        btnCantidad.setOnAction(event -> {

            int cantidad = estudiantes.size();

            lblResultado.setText("Cantidad de estudiantes: " + cantidad);
        });

        root.getChildren().addAll(
                lblTitle,
                tfEstudiante,
                btnAgregar,
                btnBuscar,
                btnEliminar,
                btnCantidad,
                lblResultado,
                lblLista
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }
}
