module uamv.edu.ni.practicasalario {
    requires javafx.controls;
    requires javafx.fxml;


    opens uamv.edu.ni.practicasalario to javafx.fxml;
    exports uamv.edu.ni.practicasalario;
}