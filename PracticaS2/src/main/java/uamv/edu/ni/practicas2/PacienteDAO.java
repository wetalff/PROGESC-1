package uamv.edu.ni.practicas2;

import uamv.edu.ni.practicas2.interfaces.CRUD;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO implements CRUD<Paciente> {


    List<Paciente> pacientes;

    public PacienteDAO(){
        pacientes = new ArrayList<>();
    }

    @Override
    public void agregar(Paciente entidad) {
        pacientes.add(entidad);
    }

    @Override
    public List<Paciente> obtenerDatos() {
        return pacientes;
    }

}
