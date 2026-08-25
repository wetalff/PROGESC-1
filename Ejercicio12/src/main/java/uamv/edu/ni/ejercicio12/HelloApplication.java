package uamv.edu.ni.ejercicio12;

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

        Label lblTitle = new Label("Invertir palabra o frase");

        TextField tfTexto = new TextField();
        tfTexto.setPromptText("Ingrese una palabra o frase");

        Button btnInvertir = new Button("Invertir");

        Label lblResultado = new Label("Resultado:");

        ArrayList<Character> pila = new ArrayList<>();

        btnInvertir.setOnAction(event -> {

            String texto = tfTexto.getText();

            pila.clear();

            // Agregar cada carácter a la pila
            for (int i = 0; i < texto.length(); i++) {

                pila.add(texto.charAt(i));
            }

            String invertido = "";

            // Sacar los caracteres de la pila
            while (!pila.isEmpty()) {

                int posicion = pila.size() - 1;

                invertido += pila.get(posicion);

                pila.remove(posicion);
            }

            lblResultado.setText(
                    "Resultado: " + invertido
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfTexto,
                btnInvertir,
                lblResultado
        );

        Scene scene = new Scene(root, 500, 300);

        stage.setTitle("Invertir texto");
        stage.setScene(scene);
        stage.show();
    }

}