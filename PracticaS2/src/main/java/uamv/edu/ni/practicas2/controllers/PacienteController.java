package uamv.edu.ni.practicas2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import uamv.edu.ni.practicas2.Paciente;
import uamv.edu.ni.practicas2.PacienteDAO;

import java.time.LocalDate;

public class PacienteController {
    PacienteDAO pacientes = new PacienteDAO();

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private Label lblContador;
    @FXML
    private DatePicker dpFechaNac;
    @FXML
    CheckBox cbTieneSeguro;

    @FXML
    protected void agregarButtonOnClick(){
        leerDatos();
        limpiarCampos();
        cantidadPaciente();


    }

    private void leerDatos(){
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        agregarPaciente(new Paciente(nombres, apellidos, dpFechaNac.getValue(), cbTieneSeguro.isSelected()));
        LocalDate fechaNacimiento = dpFechaNac.getValue();
        boolean tieneSeguro = this.cbTieneSeguro.isSelected();
        agregarPaciente(new Paciente(nombres, apellidos, fechaNacimiento, tieneSeguro));

    }

    private void agregarPaciente(Paciente paciente){
        pacientes.agregar(paciente);
    }

    private void cantidadPaciente(){
        lblContador.setText("Registros Almacenados: " + pacientes.obtenerDatos().size());
    }

    private void limpiarCampos(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtNombres.requestFocus();
    }


}
