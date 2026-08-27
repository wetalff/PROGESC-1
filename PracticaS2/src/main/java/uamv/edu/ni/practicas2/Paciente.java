package uamv.edu.ni.practicas2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente {
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean tieneSeguro;
    private String sexo;


    public Paciente(String nombres, String apellidos, LocalDate fechaNacimiento, boolean tieneSeguro) {
    }
}
