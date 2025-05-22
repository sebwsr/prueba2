package Dream;

public class Producto {
	private String nombre;
	private double precio;
	private String categoria;
	private int stock;
	
	public Producto(String nombre, double precio, String categoria, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
	}
	
	public boolean hayStock(int cantidad) {
		return this.stock >= cantidad;
	}
	
	public void actualizarStock(int cantidadVendida) {
		if(hayStock(cantidadVendida))
			this.stock -= cantidadVendida;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
}
