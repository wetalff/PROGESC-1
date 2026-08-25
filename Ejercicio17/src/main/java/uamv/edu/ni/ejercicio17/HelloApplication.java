package uamv.edu.ni.ejercicio17;

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

        Label lblTitle = new Label("Administración de libros");

        TextField tfLibro = new TextField();
        tfLibro.setPromptText("Nombre del libro");

        ArrayList<String> libros = new ArrayList<>();
        ArrayList<Boolean> disponibles = new ArrayList<>();

        Button btnRegistrar = new Button("Registrar libro");
        Button btnBuscar = new Button("Buscar libro");
        Button btnPrestar = new Button("Prestar libro");
        Button btnDevolver = new Button("Devolver libro");
        Button btnDisponibles = new Button("Contar libros disponibles");

        Label lblResultado = new Label("Resultado:");

        // Registrar libro
        btnRegistrar.setOnAction(event -> {

            String libro = tfLibro.getText();

            libros.add(libro);
            disponibles.add(true);

            lblResultado.setText(
                    "Libro registrado: " + libro
            );

            tfLibro.clear();
        });

        // Buscar libro
        btnBuscar.setOnAction(event -> {

            String libroBuscado = tfLibro.getText();

            if (libros.contains(libroBuscado)) {

                int posicion = libros.indexOf(libroBuscado);

                if (disponibles.get(posicion)) {

                    lblResultado.setText(
                            "Libro encontrado y disponible."
                    );

                } else {

                    lblResultado.setText(
                            "Libro encontrado, pero está prestado."
                    );
                }

            } else {

                lblResultado.setText(
                        "Libro no encontrado."
                );
            }
        });

        // Prestar libro
        btnPrestar.setOnAction(event -> {

            String libroBuscado = tfLibro.getText();

            if (libros.contains(libroBuscado)) {

                int posicion = libros.indexOf(libroBuscado);

                if (disponibles.get(posicion)) {

                    disponibles.set(posicion, false);

                    lblResultado.setText(
                            "Libro prestado: " + libroBuscado
                    );

                } else {

                    lblResultado.setText(
                            "El libro ya está prestado."
                    );
                }

            } else {

                lblResultado.setText(
                        "Libro no encontrado."
                );
            }
        });

        // Devolver libro
        btnDevolver.setOnAction(event -> {

            String libroBuscado = tfLibro.getText();

            if (libros.contains(libroBuscado)) {

                int posicion = libros.indexOf(libroBuscado);

                if (!disponibles.get(posicion)) {

                    disponibles.set(posicion, true);

                    lblResultado.setText(
                            "Libro devuelto: " + libroBuscado
                    );

                } else {

                    lblResultado.setText(
                            "El libro ya está disponible."
                    );
                }

            } else {

                lblResultado.setText(
                        "Libro no encontrado."
                );
            }
        });

        // Contar libros disponibles
        btnDisponibles.setOnAction(event -> {

            int cantidad = 0;

            for (int i = 0; i < disponibles.size(); i++) {

                if (disponibles.get(i)) {

                    cantidad++;
                }
            }

            lblResultado.setText(
                    "Libros disponibles: " + cantidad
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfLibro,
                btnRegistrar,
                btnBuscar,
                btnPrestar,
                btnDevolver,
                btnDisponibles,
                lblResultado
        );

        Scene scene = new Scene(root, 550, 400);

        stage.setTitle("Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}