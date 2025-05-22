import java.util.*;
public class SistemaTienda {
     private List<Producto> productos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Validaciones validacion = new Validaciones(scanner);
    int opcion = -1;

    public void iniciar() {
        while (opcion != 6) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║        MENÚ PRINCIPAL        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1️⃣  Registrar Producto        ║");
            System.out.println("║ 2️⃣  Registrar Cliente         ║");
            System.out.println("║ 3️⃣  Realizar Venta            ║");
            System.out.println("║ 4️⃣  Productos Registrados     ║");
            System.out.println("║ 5️⃣  Clientes Registrados      ║");
            System.out.println("║ 6️⃣  Salir                     ║");
            System.out.println("╚══════════════════════════════╝");

            opcion = validacion.pedirOpcionMenu("Elija una opción: ", 1, 6);

            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> registrarCliente();
                case 3 -> realizarVenta();
                case 4 -> mostrarProductos();
                case 5 -> mostrarClientes();
                case 6 -> {
                    System.out.println("Saliendo..... ¡Hasta pronto!");
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void registrarProducto() {
        System.out.println("Registro de Producto");
        String nombre = validacion.pedirNombre("Nombre del producto: ");
        String categoria = validacion.pedirNombre("Categoría: ");
        double precio = validacion.pedirDoublePositivo("Precio: ");
        int stock = validacion.pedirEnteroPositivo("Stock: ");

        Producto producto = new Producto(nombre, precio, categoria, stock);
        productos.add(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    private void registrarCliente() {
        System.out.println("Registro de Cliente");
        String nombre = validacion.pedirNombre("Nombre del cliente: ");
        String correo = validacion.pedirCorreo();

        Cliente cliente = new Cliente(nombre, correo);
        clientes.add(cliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    private void realizarVenta() {
        String correo = validacion.pedirCorreo();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(correo))
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("El Cliente no se ha encontrado.");
            return;
        }

        Venta venta = new Venta(cliente);
        int opcion = -1;

        while (opcion != 4) {
            System.out.println("\n🛒 MENÚ DE VENTA");
            System.out.println("----------------------------");
            System.out.println("1️⃣  Agregar Producto");
            System.out.println("2️⃣  Eliminar Producto");
            System.out.println("3️⃣  Recibo Provisional");
            System.out.println("4️⃣  Finalizar Venta");

            opcion = validacion.pedirOpcionMenu("Elija una opción: ", 1, 4);

            switch (opcion) {
                case 1 -> {
                    String nombreProd = validacion.pedirNombre("Ingrese el Nombre del Producto: ");
                    Producto prod = productos.stream()
                            .filter(p -> p.getNombre().equalsIgnoreCase(nombreProd))
                            .findFirst()
                            .orElse(null);

                    if (prod == null) {
                        System.out.println("Producto no encontrado.");
                        continue;
                    }

                    int cantidad = validacion.pedirEnteroPositivo("Ingrese la Cantidad: ");

                    try {
                        venta.agregarProducto(prod, cantidad);
                        System.out.println("Producto agregado correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    String nombreEliminar = validacion.pedirNombre("Ingrese el Nombre del producto a eliminar: ");
                    Producto prodEliminar = productos.stream()
                            .filter(p -> p.getNombre().equalsIgnoreCase(nombreEliminar))
                            .findFirst()
                            .orElse(null);

                    if (prodEliminar != null) {
                        venta.eliminarProducto(prodEliminar);
                        System.out.println("El Producto se ha eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado en la venta.");
                    }
                }
                case 3 -> venta.generarRecibo();
                case 4 -> {
                    venta.finalizarVenta();
                    ventas.add(venta);
                    venta.generarRecibo();
                    return;
                }
            }
        }
    }

    private void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Producto p : productos) {
                System.out.println("Nombre: " + p.getNombre() +
                        " | Precio: $" + p.getPrecio() +
                        " | Categoría: " + p.getCategoria() +
                        " | Stock: " + p.getStock());
            }
        }
    }

    private void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- LISTA DE CLIENTES ---");
            for (Cliente c : clientes) {
                System.out.println("Nombre: " + c.getNombre() +
                        " | Correo: " + c.getCorreo());
            }
        }
    }
}
