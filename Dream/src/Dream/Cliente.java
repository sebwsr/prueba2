package Dream;

public class Cliente {
	private String nombre;
	private String correo;
	
	public Cliente(String nombre, String correo) {
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public String obtenerInformacion() {
		return "Nombre: " + nombre + " | Correo: " + correo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
