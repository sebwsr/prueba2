package Laberinto1;



public class Habitacion {
	
	public static final  int ancho=10;
	public static final  int alto=15;
    private Posicion puertaEntrada;
    private Posicion puertaSalida;
    private Jugador J;
    private Rata R;
   
	
    
    public Habitacion() {
    	System.out.println("Creación de una habitación");
		
	}




	public Habitacion(Posicion puertaEntrada, Posicion puertaSalida, Jugador J) {
		this.puertaEntrada = puertaEntrada;
		this.puertaSalida = puertaSalida;
		this.J = J;
		
		this.J.setPos(puertaEntrada);
		
	}
	public Posicion getPuertaEntrada() {
		return puertaEntrada;
	}


	public void setPuertaEntrada(Posicion puertaEntrada) {
		
		//mejora que solo permite puertas y salidas en los bordes
		    /*boolean Borde = 
		        (puertaEntrada.getPosy() == 0 || puertaEntrada.getPosy() == ancho - 1) ||  // Bordes verticales
		        (puertaEntrada.getPosx() == 0 || puertaEntrada.getPosx() == alto - 1);      // Bordes horizontales

		    if (Borde) {
		        this.puertaEntrada = puertaEntrada;
		    }//else  this.puertaEntrada= new Posicion(6, 0);*/
		this.puertaEntrada = puertaEntrada;
			
	}
	public Posicion getPuertaSalida() {
		return puertaSalida;
	}
	public void setPuertaSalida(Posicion puertaSalida) {
		/*boolean Borde = 
		        (puertaSalida.getPosy() == 0 || puertaSalida.getPosy() == ancho - 1) ||  // Bordes verticales
		        (puertaSalida.getPosx() == 0 || puertaSalida.getPosx() == alto - 1);      // Bordes horizontales
		
		if (Borde) {
		        this.puertaSalida = puertaSalida;
		}//else this.puertaSalida= new Posicion(0, 10);*/
		this.puertaSalida = puertaSalida;
	}


	public void setJugador(Jugador J) {
		this.J = J;
		
	} 
	
	public void setR(Rata R) {
		this.R = R;
	}


	public boolean esunaPuerta(Posicion p) {
		if(p.soniguales(puertaEntrada) || p.soniguales(puertaSalida)) return true;
		return false;
	}
	public boolean esunJugador(Posicion p) {
		if(p.soniguales(J.getPos())) return true;
		return false;
	}


    
    
	


	

}
