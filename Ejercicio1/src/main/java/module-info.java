module uamv.edu.ni.ejercicio1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens uamv.edu.ni.ejercicio1 to javafx.fxml;
    exports uamv.edu.ni.ejercicio1;
}