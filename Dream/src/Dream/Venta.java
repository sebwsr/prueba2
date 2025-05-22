package Dream;
import java.util.*;

public class Venta {
	private Cliente cliente;
	private List<Producto> productosVendidos;
	private List<Integer> cantidades;
	private Date fecha;
	
	public Venta(Cliente cliente) {
		this.cliente = cliente;
		this.productosVendidos = new ArrayList<>();
		this.cantidades = new ArrayList<>();
		this.fecha = new Date();
	}
	
	public void agregarProducto(Producto producto, int cantidad) {
		if(producto.hayStock(cantidad)) {
			productosVendidos.add(producto);
			cantidades.add(cantidad);
			producto.actualizarStock(cantidad);
		}else {
			System.out.println("Stock insuficiente para: " + producto.getNombre());
		}
	}
	
	public double calcularTotal() {
		return calcularTotalRecursivo(0,0);
	}
	
	public double calcularTotalRecursivo(int index, double totalActual) {
		if(index >= productosVendidos.size()) return totalActual;
		
		double subtotal = productosVendidos.get(index).getPrecio() * cantidades.get(index);
		return calcularTotalRecursivo(index + 1, totalActual + subtotal);
	}
	
	public void mostrarResumen() {
		System.out.println("Venta realizada por: " + cliente.obtenerInformacion());
		for(int i = 0; i < productosVendidos.size(); i++) {
			Producto p = productosVendidos.get(i);
			int cant = cantidades.get(i);
			System.out.println("- " + p.getNombre() + " x" + cant + " = $" + (p.getPrecio() * cant));
		}
		System.out.println("Total: $" + calcularTotal());
	}
	
}
