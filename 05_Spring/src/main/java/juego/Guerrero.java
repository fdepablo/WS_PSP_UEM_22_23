package juego;

public class Guerrero {
	
	private Arma arma;
	
	public void atacar() {
		System.out.println("Argggggggg");
		arma.usar();
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	
}
