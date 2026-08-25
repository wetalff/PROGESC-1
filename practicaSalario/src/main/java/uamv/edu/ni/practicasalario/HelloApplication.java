package uamv.edu.ni.practicasalario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Calculadora");
        //root.getChildren().add(lblTitle);
        Label lblNumber1 = new Label("Numero 1");
        TextField tfNumber1 = new TextField();


        Button btnSuma = new Button("Calcular Salario Final");
        Button btnResta = new Button("-");
        Button btnMultiplicacion = new Button("*");
        Button btnDivision = new Button("/");
        Label lblResultado = new Label("Resultado");

        btnSuma.setOnAction(event ->{
            int num1 = Integer.parseInt(tfNumber1.getText());
            if (num1 < 12000){double resultado = (num1 + (num1 * 0.10)); double resultadof = resultado-(resultado*0.07);
                    lblResultado.setText(String.valueOf(resultadof));}
            if (20000 >num1 & num1 > 12000){double resultado = num1 + (num1 * 0.05);double resultadof = resultado-(resultado*0.07);lblResultado.setText(String.valueOf(resultadof));}
            if (num1 > 20000){double resultado = num1 + (num1 * 0.03);double resultadof = resultado-(resultado*0.07);lblResultado.setText(String.valueOf(resultadof));}


        });






        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10));
        buttons.getChildren().addAll(btnSuma,btnResta,btnDivision,btnMultiplicacion);

        root.getChildren().addAll(lblTitle, lblNumber1,tfNumber1,lblResultado, buttons);
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }
}
