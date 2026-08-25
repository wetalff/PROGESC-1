package uamv.edu.ni.ejercicio3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();
        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Ordenar números");
        Label lblNumero = new Label("Ingrese un número");

        TextField tfNumero = new TextField();

        ArrayList<Integer> numeros = new ArrayList<>();

        Button btnAgregar = new Button("Agregar número");
        Button btnOrdenar = new Button("Ordenar números");

        Label lblOriginales = new Label("Números originales:");
        Label lblOrdenados = new Label("Números ordenados:");

        Label lblOriginalesResultado = new Label();
        Label lblOrdenadosResultado = new Label();

        // Agregar números
        btnAgregar.setOnAction(event -> {

            int numero = Integer.parseInt(tfNumero.getText());

            numeros.add(numero);

            lblOriginalesResultado.setText(numeros.toString());

            tfNumero.clear();
        });

        // Ordenar números
        btnOrdenar.setOnAction(event -> {

            // Creamos una copia para conservar los originales
            ArrayList<Integer> ordenados = new ArrayList<>(numeros);

            // Bubble Sort
            for (int i = 0; i < ordenados.size() - 1; i++) {

                for (int j = 0; j < ordenados.size() - 1 - i; j++) {

                    if (ordenados.get(j) > ordenados.get(j + 1)) {

                        int temporal = ordenados.get(j);

                        ordenados.set(j, ordenados.get(j + 1));

                        ordenados.set(j + 1, temporal);
                    }
                }
            }

            lblOrdenadosResultado.setText(ordenados.toString());
        });

        root.getChildren().addAll(
                lblTitle,
                lblNumero,
                tfNumero,
                btnAgregar,
                btnOrdenar,
                lblOriginales,
                lblOriginalesResultado,
                lblOrdenados,
                lblOrdenadosResultado
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }
}