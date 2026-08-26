package uamv.edu.ni.practicas2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UsuarioController {

    PasswordDAO usuarios = new PasswordDAO();

    @FXML
    private TextField txtusuario;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button btnAcceder;





    @FXML
    protected void agregarButtonOnClick() throws IOException {
        leerDatos();
        limpiarCampos();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/uamv/edu/ni/practicas2/paciente-viex.fxml")
        );

        Parent root = loader.load();

        Stage stage = (Stage) btnAcceder.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    private void leerDatos(){
        String usuarios = txtusuario.getText();
        String passwords = txtpassword.getText();
        agregarUsuario(new Usuario(usuarios, passwords));

    }

    private void agregarUsuario(Usuario usuario){
        usuarios.agregarUsuario(usuario);
    }


    private void limpiarCampos(){
        txtusuario.setText("");
        txtpassword.setText("");

    }




}
