package Laberinto1;
import java.util.Scanner;

public class Principal {
		
    public static void main(String[] args) {
    	
    	int accion=-1;
    	int nmovi=0;
    	@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
    	
  
    	//pisiciones 
    	Posicion posI = new Posicion(0,3);
    	
     
        Posicion posS = new Posicion(5,Habitacion.alto-1);
       
        
       //Generar jugador y se coloca en la habitacion
       Jugador jugador=new Jugador(posI,"sebas");
   	   //jugador.setPos(posI);
        	
    	Habitacion  hab1=new Habitacion(posI,posS,jugador);
    	
    	
    	while(accion!=juego.Salir_del_juego)
    	{   		
    		juego.pintarMapa(hab1);
      		juego.pintarmenu();
      		accion=sc.nextInt();
      		
      		switch(accion) {
      		
      		case juego.Lanzar_Dado:
      			
      		    nmovi=juego.LanzarDado();
      			System.out.println("Movimiento en columna en X¿Cuantas columnas quieres moverte? tienes "+nmovi+" movimientos");
      			int ncol=sc.nextInt();
      			
      			jugador.moverx(ncol);
      			nmovi=nmovi-ncol;
      			//mejora para cuando se ocupen todos loa movimientos antes 
      			System.out.println("Movimiento en filas en y¿Cuantas filas quieres moverte? tienes "+nmovi+" movimientos");
      			int nfil=sc.nextInt();
      			jugador.movery(nfil);
      			break;
      		}
    	}       
    }
}
