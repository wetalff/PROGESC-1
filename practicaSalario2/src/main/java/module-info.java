module uamv.edu.ni.practicasalario2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens uamv.edu.ni.practicasalario2 to javafx.fxml;
    exports uamv.edu.ni.practicasalario2;
}