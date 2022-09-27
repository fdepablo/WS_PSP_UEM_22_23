package interfaz;

public class Caballo implements Movible{

	/**
	 * Representa la posición del objeto
	 */
	private int x;
	private String caballo;
	
	@Override
	public void moverseLento() {
		this.x += 2;
	}

	@Override
	public void moverseRapido() {
		this.x += 20;
		
	}

	@Override
	public int moverse(int x) {
		this.x += x;
		return this.x;
	}
	
}
