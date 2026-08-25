package uamv.edu.ni.practicasalario2;

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
import java.util.Collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Encontrar Salario");
        Label lblSalarios = new Label("Salarios");
        TextField tfsalarios = new TextField();
        List<java.lang.Double> Salarios = new ArrayList<>();

        Button btnSalario = new Button("Calcular promedio, Alto, Bajo y Moda");
        Button btnAgregarSalario = new Button("Agregue el salario");
        Label lblPromedio = new Label("Promedio");
        Label lblMenor = new Label("Menor");
        Label lblMayor = new Label("Mayor");
        Label lblModa = new Label("Moda");

        btnAgregarSalario.setOnAction(event ->{
            Salarios.add(Double.parseDouble(tfsalarios.getText()));

        });
        btnSalario.setOnAction(event ->{
            double maximo = Salarios.get(0);
            for(int i = 0; i < Salarios.size(); i++){
                if(Salarios.get(i) > maximo){maximo = Salarios.get(i);}
            }
            lblMayor.setText(String.valueOf(maximo));

            double minimo = Salarios.get(0);
            for(int i = 0; i < Salarios.size(); i++){
                if(Salarios.get(i) < minimo){minimo = Salarios.get(i);}
            }
            lblMenor.setText(String.valueOf(minimo));

            double promedio = 0;
            double suma = 0;
            for(int i = 0; i < Salarios.size(); i++){
                suma += Salarios.get(i);
            }
            promedio = suma / Salarios.size();
            lblPromedio.setText(String.valueOf(promedio));


            double moda = Salarios.get(0);
            int mayorFrecuencia = 0;

            for( double salario : Salarios){
                int frecuencia = Collections.frequency(Salarios, salario);

                if(frecuencia > mayorFrecuencia){
                    mayorFrecuencia = frecuencia;
                    moda = salario;
                }

            }
            if(mayorFrecuencia == 1){lblModa.setText("No hay moda");}
            else {lblModa.setText(String.valueOf(moda));}







        });

        root.getChildren().addAll(lblTitle,tfsalarios,
                btnAgregarSalario,btnSalario,lblSalarios,lblModa,lblMayor,lblMenor,lblPromedio
                );
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();

    }
}
