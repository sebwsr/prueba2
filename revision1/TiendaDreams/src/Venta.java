import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
public class Venta {
    private Cliente cliente;
    private Map<Producto, Integer> productos;
    private int cantidadProducto; 
    private double total;        
    private LocalDateTime fecha;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new HashMap<>();
        this.fecha = LocalDateTime.now();
        this.cantidadProducto = 0;
        this.total = 0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (!producto.verificarStock(cantidad)) {
            throw new IllegalArgumentException("No hay Stock suficiente para" + producto.getNombre());
        }

        producto.actualizarStock(cantidad);
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        cantidadProducto += cantidad;
        total += producto.getPrecio() * cantidad;
    }

    public void eliminarProducto(Producto producto) {
        if (productos.containsKey(producto)) {
            int cantidad = productos.get(producto);
            producto.reponerStock(cantidad); 
            cantidadProducto -= cantidad;
            total -= producto.getPrecio() * cantidad;
            productos.remove(producto);
        }
    }

    public void finalizarVenta() {
        this.fecha = LocalDateTime.now();
        System.out.println("Venta finalizada. Total: $" + total);
    }

    public void generarRecibo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n======= RECIBO DE VENTA =======");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Fecha: " + fecha.format(formatter));
        System.out.println("--------------------------------");
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto p = entry.getKey();
            int cantidad = entry.getValue();
            System.out.printf("%s x%d = $%.2f\n", p.getNombre(), cantidad, p.getPrecio() * cantidad);
        }
        System.out.println("--------------------------------");
        System.out.println("Total de productos: " + cantidadProducto);
        System.out.printf("TOTAL: $%.2f\n", total);
        System.out.println("================================\n");
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
