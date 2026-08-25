package uamv.edu.ni.ejercicio7;

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

        Label lblTitle = new Label("Inventario de productos");

        TextField tfProducto = new TextField();
        tfProducto.setPromptText("Nombre del producto");

        TextField tfPrecio = new TextField();
        tfPrecio.setPromptText("Precio");

        TextField tfCantidad = new TextField();
        tfCantidad.setPromptText("Cantidad");

        TextField tfBuscar = new TextField();
        tfBuscar.setPromptText("Producto a buscar");

        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();

        Button btnAgregar = new Button("Agregar producto");
        Button btnBuscar = new Button("Buscar producto");
        Button btnModificar = new Button("Modificar cantidad");
        Button btnEliminar = new Button("Eliminar producto");
        Button btnTotal = new Button("Calcular valor total");

        Label lblResultado = new Label("Resultado:");

        // Agregar producto
        btnAgregar.setOnAction(event -> {

            String producto = tfProducto.getText();
            double precio = Double.parseDouble(tfPrecio.getText());
            int cantidad = Integer.parseInt(tfCantidad.getText());

            productos.add(producto);
            precios.add(precio);
            cantidades.add(cantidad);

            lblResultado.setText(
                    "Producto agregado: " + producto
            );

            tfProducto.clear();
            tfPrecio.clear();
            tfCantidad.clear();
        });

        // Buscar producto
        btnBuscar.setOnAction(event -> {

            String productoBuscado = tfBuscar.getText();

            if (productos.contains(productoBuscado)) {

                int posicion = productos.indexOf(productoBuscado);

                lblResultado.setText(
                        "Producto: " + productos.get(posicion)
                                + " | Precio: " + precios.get(posicion)
                                + " | Cantidad: " + cantidades.get(posicion)
                );

            } else {

                lblResultado.setText("Producto no encontrado.");
            }
        });

        // Modificar cantidad
        btnModificar.setOnAction(event -> {

            String productoBuscado = tfBuscar.getText();
            int nuevaCantidad = Integer.parseInt(tfCantidad.getText());

            if (productos.contains(productoBuscado)) {

                int posicion = productos.indexOf(productoBuscado);

                cantidades.set(posicion, nuevaCantidad);

                lblResultado.setText(
                        "Cantidad modificada. Nueva cantidad: "
                                + nuevaCantidad
                );

            } else {

                lblResultado.setText("Producto no encontrado.");
            }
        });

        // Eliminar producto
        btnEliminar.setOnAction(event -> {

            String productoBuscado = tfBuscar.getText();

            if (productos.contains(productoBuscado)) {

                int posicion = productos.indexOf(productoBuscado);

                productos.remove(posicion);
                precios.remove(posicion);
                cantidades.remove(posicion);

                lblResultado.setText(
                        "Producto eliminado: " + productoBuscado
                );

            } else {

                lblResultado.setText("Producto no encontrado.");
            }
        });

        // Calcular valor total
        btnTotal.setOnAction(event -> {

            double total = 0;

            for (int i = 0; i < productos.size(); i++) {

                total += precios.get(i) * cantidades.get(i);
            }

            lblResultado.setText(
                    "Valor total del inventario: " + total
            );
        });

        root.getChildren().addAll(
                lblTitle,
                tfProducto,
                tfPrecio,
                tfCantidad,
                btnAgregar,
                tfBuscar,
                btnBuscar,
                btnModificar,
                btnEliminar,
                btnTotal,
                lblResultado
        );

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}