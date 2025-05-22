package Laberinto1;

public class Posicion {
	private int posx;
	private int posy;

	public Posicion() {
		this.posx = 0;
		this.posy = 0;
	}

	public Posicion(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}
     //
	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
	public boolean soniguales(Posicion p) {
		if(p.posx==this.posx  && p.posy==this.posy ) return true;
		else return false;
	}

	

}
