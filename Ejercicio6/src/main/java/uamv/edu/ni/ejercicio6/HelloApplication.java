package uamv.edu.ni.ejercicio6;

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

        Label lblTitle = new Label("Agenda de contactos");

        TextField tfNombre = new TextField();
        tfNombre.setPromptText("Nombre");

        TextField tfTelefono = new TextField();
        tfTelefono.setPromptText("Teléfono");

        TextField tfCorreo = new TextField();
        tfCorreo.setPromptText("Correo");

        TextField tfBuscar = new TextField();
        tfBuscar.setPromptText("Nombre a buscar/eliminar");

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> telefonos = new ArrayList<>();
        ArrayList<String> correos = new ArrayList<>();

        Button btnAgregar = new Button("Agregar contacto");
        Button btnBuscar = new Button("Buscar contacto");
        Button btnEliminar = new Button("Eliminar contacto");

        Label lblResultado = new Label("Resultado:");

        // Agregar contacto
        btnAgregar.setOnAction(event -> {

            nombres.add(tfNombre.getText());
            telefonos.add(tfTelefono.getText());
            correos.add(tfCorreo.getText());

            lblResultado.setText(
                    "Contacto agregado: " + tfNombre.getText()
            );

            tfNombre.clear();
            tfTelefono.clear();
            tfCorreo.clear();
        });

        // Buscar contacto
        btnBuscar.setOnAction(event -> {

            String nombreBuscado = tfBuscar.getText();

            if (nombres.contains(nombreBuscado)) {

                int posicion = nombres.indexOf(nombreBuscado);

                lblResultado.setText(
                        "Nombre: " + nombres.get(posicion)
                                + " | Teléfono: " + telefonos.get(posicion)
                                + " | Correo: " + correos.get(posicion)
                );

            } else {

                lblResultado.setText("Contacto no encontrado.");
            }
        });

        // Eliminar contacto
        btnEliminar.setOnAction(event -> {

            String nombreBuscado = tfBuscar.getText();

            if (nombres.contains(nombreBuscado)) {

                int posicion = nombres.indexOf(nombreBuscado);

                nombres.remove(posicion);
                telefonos.remove(posicion);
                correos.remove(posicion);

                lblResultado.setText(
                        "Contacto eliminado: " + nombreBuscado
                );

            } else {

                lblResultado.setText("Contacto no encontrado.");
            }
        });

        root.getChildren().addAll(
                lblTitle,
                tfNombre,
                tfTelefono,
                tfCorreo,
                btnAgregar,
                tfBuscar,
                btnBuscar,
                btnEliminar,
                lblResultado
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }

}