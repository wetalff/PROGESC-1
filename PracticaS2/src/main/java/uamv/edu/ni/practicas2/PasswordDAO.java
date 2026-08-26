package uamv.edu.ni.practicas2;

import java.util.ArrayList;
import java.util.List;

public class PasswordDAO {
    List<Usuario> usuarios;

    public PasswordDAO(){
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

}
