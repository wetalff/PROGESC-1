package uamv.edu.ni.ejercicio16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();

        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Sistema de ventas");

        TextField tfProducto = new TextField();
        tfProducto.setPromptText("Nombre del producto");

        TextField tfPrecio = new TextField();
        tfPrecio.setPromptText("Precio");

        TextField tfCantidad = new TextField();
        tfCantidad.setPromptText("Cantidad");

        TextField tfDescuento = new TextField();
        tfDescuento.setPromptText("Descuento (%)");

        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        Button btnRegistrar = new Button("Registrar producto");
        Button btnCalcular = new Button("Calcular venta");

        Label lblProductos = new Label("Productos registrados:");

        Label lblSubtotal = new Label("Subtotal:");
        Label lblDescuento = new Label("Descuento:");
        Label lblIVA = new Label("IVA:");
        Label lblTotal = new Label("Total:");

        // Registrar producto
        btnRegistrar.setOnAction(event -> {

            String producto = tfProducto.getText();
            double precio = Double.parseDouble(tfPrecio.getText());
            int cantidad = Integer.parseInt(tfCantidad.getText());

            productos.add(producto);
            precios.add(precio);
            cantidades.add(cantidad);

            lblProductos.setText(
                    "Productos registrados: " + productos
            );

            tfProducto.clear();
            tfPrecio.clear();
            tfCantidad.clear();
        });

        // Calcular venta
        btnCalcular.setOnAction(event -> {

            double subtotal = 0;

            for (int i = 0; i < productos.size(); i++) {

                subtotal += precios.get(i) * cantidades.get(i);
            }

            double descuentoPorcentaje =
                    Double.parseDouble(tfDescuento.getText());

            double descuento =
                    subtotal * descuentoPorcentaje / 100;

            double subtotalConDescuento =
                    subtotal - descuento;

            double iva =
                    subtotalConDescuento * 0.15;

            double total =
                    subtotalConDescuento + iva;

            lblSubtotal.setText(
                    "Subtotal: " + subtotal
            );

            lblDescuento.setText(
                    "Descuento: " + descuento
            );

            lblIVA.setText(
                    "IVA: " + iva
            );

            lblTotal.setText(
                    "Total: " + total
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfProducto,
                tfPrecio,
                tfCantidad,
                btnRegistrar,
                lblProductos,
                tfDescuento,
                btnCalcular,
                lblSubtotal,
                lblDescuento,
                lblIVA,
                lblTotal
        );

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("Sistema de ventas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}