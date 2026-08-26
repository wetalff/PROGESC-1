package uamv.edu.ni.practicas2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;



public class UsuarioApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(UsuarioApplication.class.getResource("/uamv/edu/ni/practicas2/password-view.fxml"));
        Scene scene = new Scene( fxmlLoader.load());
        stage.setTitle("Usuario");
        stage.setScene(scene);
        stage.show();
    }

}
