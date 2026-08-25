package uamv.edu.ni.ejercicio9;

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

        Label lblTitle = new Label("Pila de números");

        TextField tfNumero = new TextField();
        tfNumero.setPromptText("Ingrese un número");

        ArrayList<Integer> pila = new ArrayList<>();

        Button btnPush = new Button("Push");
        Button btnPop = new Button("Pop");
        Button btnPeek = new Button("Peek");
        Button btnMostrar = new Button("Mostrar pila");
        Button btnVacia = new Button("Verificar si está vacía");

        Label lblResultado = new Label("Resultado:");

        // PUSH
        btnPush.setOnAction(event -> {

            int numero = Integer.parseInt(tfNumero.getText());

            pila.add(numero);

            lblResultado.setText(
                    "Número agregado: " + numero
            );

            tfNumero.clear();
        });

        // POP
        btnPop.setOnAction(event -> {

            if (!pila.isEmpty()) {

                int posicion = pila.size() - 1;

                int numero = pila.get(posicion);

                pila.remove(posicion);

                lblResultado.setText(
                        "Número eliminado: " + numero
                );

            } else {

                lblResultado.setText("La pila está vacía.");
            }
        });

        // PEEK
        btnPeek.setOnAction(event -> {

            if (!pila.isEmpty()) {

                int posicion = pila.size() - 1;

                int numero = pila.get(posicion);

                lblResultado.setText(
                        "Elemento en la cima: " + numero
                );

            } else {

                lblResultado.setText("La pila está vacía.");
            }
        });

        // MOSTRAR PILA
        btnMostrar.setOnAction(event -> {

            lblResultado.setText(
                    "Pila: " + pila
            );
        });

        // VERIFICAR SI ESTÁ VACÍA
        btnVacia.setOnAction(event -> {

            if (pila.isEmpty()) {

                lblResultado.setText("La pila está vacía.");

            } else {

                lblResultado.setText(
                        "La pila NO está vacía."
                );
            }
        });

        root.getChildren().addAll(
                lblTitle,
                tfNumero,
                btnPush,
                btnPop,
                btnPeek,
                btnMostrar,
                btnVacia,
                lblResultado
        );

        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("Pila");
        stage.setScene(scene);
        stage.show();
    }

    
}