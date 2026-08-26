package uamv.edu.ni.practicas2;

import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {


    List<Paciente> pacientes;

    public PacienteDAO(){
        pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }


    public List<Paciente> listarPacientes(){
        return pacientes;
    }
}
