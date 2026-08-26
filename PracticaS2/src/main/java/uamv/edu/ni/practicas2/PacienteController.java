package uamv.edu.ni.practicas2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PacienteController {
    PacienteDAO pacientes = new PacienteDAO();

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private Label lblContador;


    @FXML
    protected void agregarButtonOnClick(){
        leerDatos();
        limpiarCampos();
        cantidadPaciente();


    }

    private void leerDatos(){
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        agregarPaciente(new Paciente(nombres, apellidos));

    }

    private void agregarPaciente(Paciente paciente){
        pacientes.agregarPaciente(paciente);
    }

    private void cantidadPaciente(){
        lblContador.setText("Registros Almacenados: " + pacientes.listarPacientes().size());
    }

    private void limpiarCampos(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtNombres.requestFocus();
    }


}
