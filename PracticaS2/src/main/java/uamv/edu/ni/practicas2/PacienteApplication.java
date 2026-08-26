package uamv.edu.ni.practicas2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PacienteApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(PacienteApplication.class.getResource("paciente-viex.fxml"));
        Scene scene = new Scene( fxmlLoader.load());
        stage.setTitle("Paciente");
        stage.setScene(scene);
        stage.show();
    }
}
