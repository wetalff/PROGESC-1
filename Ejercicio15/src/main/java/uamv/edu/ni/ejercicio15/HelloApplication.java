package uamv.edu.ni.ejercicio15;

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

        Label lblTitle = new Label("Cola de impresión");

        TextField tfDocumento = new TextField();
        tfDocumento.setPromptText("Nombre del documento");

        ArrayList<String> documentos = new ArrayList<>();

        Button btnAgregar = new Button("Agregar documento");
        Button btnImprimir = new Button("Imprimir documento");
        Button btnSiguiente = new Button("Mostrar siguiente");
        Button btnPendientes = new Button("Documentos pendientes");

        Label lblResultado = new Label("Resultado:");

        // Agregar documento
        btnAgregar.setOnAction(event -> {

            String documento = tfDocumento.getText();

            documentos.add(documento);

            lblResultado.setText(
                    "Documento agregado: " + documento
            );

            tfDocumento.clear();
        });

        // Imprimir documento
        btnImprimir.setOnAction(event -> {

            if (!documentos.isEmpty()) {

                String documento = documentos.get(0);

                documentos.remove(0);

                lblResultado.setText(
                        "Imprimiendo: " + documento
                );

            } else {

                lblResultado.setText(
                        "No hay documentos pendientes."
                );
            }
        });

        // Mostrar siguiente
        btnSiguiente.setOnAction(event -> {

            if (!documentos.isEmpty()) {

                String documento = documentos.get(0);

                lblResultado.setText(
                        "Siguiente documento: " + documento
                );

            } else {

                lblResultado.setText(
                        "No hay documentos pendientes."
                );
            }
        });

        // Documentos pendientes
        btnPendientes.setOnAction(event -> {

            int cantidad = documentos.size();

            lblResultado.setText(
                    "Documentos pendientes: " + cantidad
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfDocumento,
                btnAgregar,
                btnImprimir,
                btnSiguiente,
                btnPendientes,
                lblResultado
        );

        Scene scene = new Scene(root, 500, 350);

        stage.setTitle("Cola de impresión");
        stage.setScene(scene);
        stage.show();
    }


}