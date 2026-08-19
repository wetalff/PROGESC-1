module uamv.edu.ni.ejemplo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens uamv.edu.ni.ejemplo2 to javafx.fxml;
    exports uamv.edu.ni.ejemplo2;
}