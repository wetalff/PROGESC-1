package uamv.edu.ni.ejercicio4;

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

        Label lblTitle = new Label("Registro de notas");
        Label lblNota = new Label("Ingrese la nota del estudiante");

        TextField tfNota = new TextField();

        ArrayList<Double> notas = new ArrayList<>();

        Button btnAgregar = new Button("Agregar nota");
        Button btnCalcular = new Button("Calcular resultados");

        Label lblNotas = new Label("Notas registradas:");
        Label lblNotasResultado = new Label();

        Label lblPromedio = new Label("Promedio general:");
        Label lblMayor = new Label("Nota mayor:");
        Label lblMenor = new Label("Nota menor:");
        Label lblAprobados = new Label("Cantidad de aprobados:");
        Label lblReprobados = new Label("Cantidad de reprobados:");

        // Agregar nota
        btnAgregar.setOnAction(event -> {

            double nota = Double.parseDouble(tfNota.getText());

            notas.add(nota);

            lblNotasResultado.setText(notas.toString());

            tfNota.clear();
        });

        // Calcular resultados
        btnCalcular.setOnAction(event -> {

            double suma = 0;
            double mayor = notas.get(0);
            double menor = notas.get(0);

            int aprobados = 0;
            int reprobados = 0;

            for (int i = 0; i < notas.size(); i++) {

                double nota = notas.get(i);

                suma += nota;

                if (nota > mayor) {
                    mayor = nota;
                }

                if (nota < menor) {
                    menor = nota;
                }

                if (nota >= 60) {
                    aprobados++;
                } else {
                    reprobados++;
                }
            }

            double promedio = suma / notas.size();

            lblPromedio.setText("Promedio general: " + promedio);
            lblMayor.setText("Nota mayor: " + mayor);
            lblMenor.setText("Nota menor: " + menor);
            lblAprobados.setText("Cantidad de aprobados: " + aprobados);
            lblReprobados.setText("Cantidad de reprobados: " + reprobados);
        });

        root.getChildren().addAll(
                lblTitle,
                lblNota,
                tfNota,
                btnAgregar,
                lblNotas,
                lblNotasResultado,
                btnCalcular,
                lblPromedio,
                lblMayor,
                lblMenor,
                lblAprobados,
                lblReprobados
        );

        Scene scene = new Scene(root, 600, 450);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }
}
