package Laberinto1;

import java.util.Random;



public class juego {
    private static Random random = new Random();    
    final static int Lanzar_Dado=1;
    final static int Salir_del_juego=0;
	public juego() {
		// TODO Auto-generated constructor stub
	}
	
	public static void pintarMapa(Habitacion h) {		
	
		for(int fila=-1;fila < Habitacion.alto;fila++) {
		   for(int columna=0;columna<=Habitacion.ancho;columna++) {	
			   Posicion posActual=new Posicion(columna,fila);
			   
			    if(h.esunJugador(posActual))  System.out.print("J");				   
			    else if(fila==-1 && columna!=Habitacion.ancho) System.out.print(columna);
			    else if(columna==Habitacion.ancho && fila!=-1)System.out.print(fila);	
			    else if(h.esunaPuerta(posActual)) System.out.print(" ");	
			    else if((columna==0) || (columna==Habitacion.ancho-1) ) System.out.print("|"); 
				else if((fila==0) || (fila==Habitacion.alto-1))System.out.print("=");							 	
				else System.out.print(" ");	
								
				if(columna==Habitacion.ancho)System.out.println();
		
			}
		}
	}
	
	
	public static int LanzarDado() {		
		int r=random.nextInt(6) + 1;
		System.out.println("dado lanzado"+ r);   	
        return r;
	}
	public static void pintarmenu() {
		
		 System.out.println(" --------------menu---");
		 System.out.println("[1] LANZAR DADO DE MOVIMIENTO");	
		 System.out.println("[0] FINALIZAR JUEGO");	
		 System.out.println("-----------------------");	
		 
		
			 
		 }	 
		
	
}
