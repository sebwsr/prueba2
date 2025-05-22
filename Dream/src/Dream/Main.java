package Dream;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Producto> inventario = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        inicializarProductos();

        System.out.println("=== Bienvenido a la tienda DREAMS ===");

        Cliente cliente = registrarCliente();

        Venta venta = new Venta(cliente);

        boolean seguirComprando = true;

        while (seguirComprando) {
            mostrarProductos();

            System.out.print("Ingrese el número del producto que desea comprar: ");
            int opcion = leerEnteroSeguro();

            if (opcion < 1 || opcion > inventario.size()) {
                System.out.println("Opción inválida.");
                continue;
            }

            Producto productoSeleccionado = inventario.get(opcion - 1);

            System.out.print("¿Cuántas unidades desea comprar?: ");
            int cantidad = leerEnteroSeguro();

            venta.agregarProducto(productoSeleccionado, cantidad);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            seguirComprando = respuesta.equals("s");
        }

        System.out.println("\n=== RESUMEN DE LA VENTA ===");
        venta.mostrarResumen();
        System.out.println("Gracias por su compra.");
    }

    // 🧾 Método para registrar un cliente
    public static Cliente registrarCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el correo del cliente:");
        String correo = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, correo);
        clientes.add(cliente);
        return cliente;
    }

    // 📦 Inicializa productos de ejemplo
    public static void inicializarProductos() {
        inventario.add(new Producto("Laptop", 15000, "Electrónica", 5));
        inventario.add(new Producto("Perfume", 1200, "Belleza", 10));
        inventario.add(new Producto("Camisa", 600, "Ropa", 3));
        inventario.add(new Producto("Celular", 8000, "Electrónica", 7));
        inventario.add(new Producto("Zapatos", 900, "Calzado", 4));
    }

 // 🛍️ Muestra los productos disponibles
    public static void mostrarProductos() {
        System.out.println("\n=== Productos disponibles ===");
        for (int i = 0; i < inventario.size(); i++) {
            Producto p = inventario.get(i);
            System.out.printf("%d. %s | Precio: $%.2f | Stock: %d\n",
                    i + 1, p.getNombre(), p.getPrecio(), p.getStock());
        }
    }

    // ✔️ Valida que la entrada sea un entero
    public static int leerEnteroSeguro() {
        while (true) {
            try {
                String entrada = scanner.nextLine();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Intente nuevamente: ");
            }
        }
    }
}