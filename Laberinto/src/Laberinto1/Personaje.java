package Laberinto1;

public class Personaje {

	    private String nombre;
	    private Posicion pos;
	    
	      public Personaje(String nombre, Posicion pos) {
			this.nombre = nombre;
			this.pos = pos;
			
		}
	    public Personaje() {
	    	System.out.println("se crearon personajes ");
	    	
	    }

	  

		//getters and setters de nombre
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public Posicion getPos() {
	        return pos;
	    }

	    public void setPos(Posicion pos) {
	        this.pos = pos;
	    }
	    public void  moverx(int n) {
	    	this.pos.setPosx(this.pos.getPosx()+n);
	    	                       
	    	
	    }
	    public void  movery(int m) {
	    	this.pos.setPosy(this.pos.getPosy()+m);
	    	                         
	    	
	    }

}
