module uamv.edu.ni.practicas2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens uamv.edu.ni.practicas2 to javafx.fxml;
    exports uamv.edu.ni.practicas2;
}