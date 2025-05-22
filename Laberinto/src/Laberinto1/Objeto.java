package Laberinto1;

public class Objeto {
	private String nombre;
	private int tamaño;
	Posicion PosA;
	

	public Objeto() {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTamaño() {
		return tamaño;
	}


	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}


	public Posicion getPosA() {
		return PosA;
	}


	public void setPosA(Posicion posA) {
		PosA = posA;
	}

}
