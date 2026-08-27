package uamv.edu.ni.practicas2.interfaces;

import java.util.List;

public interface CRUD<T> {
    public void agregar(T entidad);
    public List<T> obtenerDatos();
}





