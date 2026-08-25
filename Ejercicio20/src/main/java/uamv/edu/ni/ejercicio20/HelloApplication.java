package uamv.edu.ni.ejercicio20;

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

    // ArrayList para productos
    ArrayList<String> productos = new ArrayList<>();
    ArrayList<Double> precios = new ArrayList<>();
    ArrayList<Integer> cantidades = new ArrayList<>();

    // Cola para clientes
    ArrayList<String> clientes = new ArrayList<>();

    // Pila para historial
    ArrayList<String> historial = new ArrayList<>();

    // Arreglo
    String[] categorias = {
            "Tecnología",
            "Ropa",
            "Alimentos",
            "Hogar"
    };

    // Contador de turnos
    int numeroTurno = 1;

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();

        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Sistema de gestión");

        TextField tfProducto = new TextField();
        tfProducto.setPromptText("Nombre del producto");

        TextField tfPrecio = new TextField();
        tfPrecio.setPromptText("Precio");

        TextField tfCantidad = new TextField();
        tfCantidad.setPromptText("Cantidad");

        TextField tfCliente = new TextField();
        tfCliente.setPromptText("Nombre del cliente");

        Button btnProducto = new Button("Registrar producto");
        Button btnBuscar = new Button("Buscar producto");
        Button btnCliente = new Button("Agregar cliente");
        Button btnAtender = new Button("Atender cliente");
        Button btnInventario = new Button("Mostrar inventario");
        Button btnHistorial = new Button("Mostrar historial");

        Label lblResultado = new Label("Resultado:");

        // Registrar producto
        btnProducto.setOnAction(event -> {

            registrarProducto(
                    tfProducto,
                    tfPrecio,
                    tfCantidad,
                    lblResultado
            );
        });

        // Buscar producto
        btnBuscar.setOnAction(event -> {

            buscarProducto(
                    tfProducto,
                    lblResultado
            );
        });

        // Agregar cliente
        btnCliente.setOnAction(event -> {

            registrarCliente(
                    tfCliente,
                    lblResultado
            );
        });

        // Atender cliente
        btnAtender.setOnAction(event -> {

            atenderCliente(lblResultado);
        });

        // Mostrar inventario
        btnInventario.setOnAction(event -> {

            mostrarInventario(lblResultado);
        });

        // Mostrar historial
        btnHistorial.setOnAction(event -> {

            mostrarHistorial(lblResultado);
        });

        root.getChildren().addAll(
                lblTitle,

                tfProducto,
                tfPrecio,
                tfCantidad,

                btnProducto,
                btnBuscar,

                tfCliente,

                btnCliente,
                btnAtender,

                btnInventario,
                btnHistorial,

                lblResultado
        );

        Scene scene = new Scene(root, 600, 600);

        stage.setTitle("Proyecto Final");
        stage.setScene(scene);
        stage.show();
    }

    // ============================
    // MÉTODO REGISTRAR PRODUCTO
    // ============================

    public void registrarProducto(
            TextField tfProducto,
            TextField tfPrecio,
            TextField tfCantidad,
            Label lblResultado) {

        try {

            String producto = tfProducto.getText();

            if (producto.isEmpty()) {

                lblResultado.setText(
                        "Ingrese el nombre del producto."
                );

                return;
            }

            double precio =
                    Double.parseDouble(tfPrecio.getText());

            int cantidad =
                    Integer.parseInt(tfCantidad.getText());

            if (precio < 0 || cantidad < 0) {

                lblResultado.setText(
                        "El precio y la cantidad no pueden ser negativos."
                );

                return;
            }

            productos.add(producto);
            precios.add(precio);
            cantidades.add(cantidad);

            // Guardar operación en la pila
            historial.add(
                    "Producto registrado: " + producto
            );

            lblResultado.setText(
                    "Producto registrado correctamente."
            );

            tfProducto.clear();
            tfPrecio.clear();
            tfCantidad.clear();

        } catch (NumberFormatException e) {

            lblResultado.setText(
                    "Ingrese números válidos en precio y cantidad."
            );
        }
    }

    // ============================
    // MÉTODO BUSCAR PRODUCTO
    // ============================

    public void buscarProducto(
            TextField tfProducto,
            Label lblResultado) {

        String productoBuscado =
                tfProducto.getText();

        if (productoBuscado.isEmpty()) {

            lblResultado.setText(
                    "Ingrese un producto para buscar."
            );

            return;
        }

        if (productos.contains(productoBuscado)) {

            int posicion =
                    productos.indexOf(productoBuscado);

            lblResultado.setText(
                    "Producto: " + productos.get(posicion)
                            + " | Precio: " + precios.get(posicion)
                            + " | Cantidad: " + cantidades.get(posicion)
            );

        } else {

            lblResultado.setText(
                    "Producto no encontrado."
            );
        }
    }

    // ============================
    // MÉTODO REGISTRAR CLIENTE
    // ============================

    public void registrarCliente(
            TextField tfCliente,
            Label lblResultado) {

        String cliente =
                tfCliente.getText();

        if (cliente.isEmpty()) {

            lblResultado.setText(
                    "Ingrese el nombre del cliente."
            );

            return;
        }

        String turno =
                "T" + String.format("%03d", numeroTurno);

        numeroTurno++;

        clientes.add(
                cliente + " - " + turno
        );

        historial.add(
                "Cliente registrado: " + cliente
                        + " - " + turno
        );

        lblResultado.setText(
                "Turno asignado: " + turno
        );

        tfCliente.clear();
    }

    // ============================
    // MÉTODO ATENDER CLIENTE
    // ============================

    public void atenderCliente(
            Label lblResultado) {

        if (!clientes.isEmpty()) {

            String cliente =
                    clientes.get(0);

            clientes.remove(0);

            historial.add(
                    "Cliente atendido: " + cliente
            );

            lblResultado.setText(
                    "Atendiendo: " + cliente
            );

        } else {

            lblResultado.setText(
                    "No hay clientes pendientes."
            );
        }
    }

    // ============================
    // MÉTODO MOSTRAR INVENTARIO
    // ============================

    public void mostrarInventario(
            Label lblResultado) {

        if (productos.isEmpty()) {

            lblResultado.setText(
                    "No hay productos registrados."
            );

            return;
        }

        String inventario = "Inventario: ";

        for (int i = 0; i < productos.size(); i++) {

            inventario +=
                    productos.get(i)
                            + " ($" + precios.get(i)
                            + ") x " + cantidades.get(i)
                            + " | ";
        }

        lblResultado.setText(inventario);
    }

    // ============================
    // MÉTODO MOSTRAR HISTORIAL
    // ============================

    public void mostrarHistorial(
            Label lblResultado) {

        if (historial.isEmpty()) {

            lblResultado.setText(
                    "No hay operaciones registradas."
            );

            return;
        }

        String texto = "Historial: ";

        for (int i = 0; i < historial.size(); i++) {

            texto += historial.get(i) + " | ";
        }

        lblResultado.setText(texto);
    }

    public static void main(String[] args) {

        launch();
    }
}