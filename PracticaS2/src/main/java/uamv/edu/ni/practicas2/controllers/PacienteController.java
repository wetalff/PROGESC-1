package uamv.edu.ni.practicas2.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import uamv.edu.ni.practicas2.Paciente;
import uamv.edu.ni.practicas2.PacienteDAO;

import java.time.LocalDate;

public class PacienteController {
    PacienteDAO pacientes = new PacienteDAO();
    public void initialize(){agrupar();}

    @FXML
    private TextField txtNombres;
    @FXML
    private ListView<String> lvlist;
    @FXML
    private TextField txtApellidos;
    @FXML
    private Label lblContador;
    @FXML
    private DatePicker dpFechaNac;
    @FXML
    CheckBox cbTieneSeguro;
    @FXML
    RadioButton rdMasculino;
    @FXML
    RadioButton rdFemenino;
    @FXML
    RadioButton rdDuran;

    ToggleGroup agrupado = new ToggleGroup();

    private void agrupar(){
        rdDuran.setToggleGroup(agrupado);
        rdFemenino.setToggleGroup(agrupado);
        rdMasculino.setToggleGroup(agrupado);
    }



    @FXML
    protected void agregarButtonOnClick(){
        obtenerDatos();
        limpiarCampos();
        cantidadPaciente();


    }

    private void obtenerDatos(){
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        LocalDate fechaNacimiento = dpFechaNac.getValue();
        boolean tieneSeguro = this.cbTieneSeguro.isSelected();
        agregarPaciente(new Paciente(nombres, apellidos, fechaNacimiento, tieneSeguro));
        lvlist.getItems().add(txtNombres.getText());


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
