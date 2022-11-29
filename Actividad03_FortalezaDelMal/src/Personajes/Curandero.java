package Personajes;

public class Curandero extends Personaje {
	public Curandero() {
		this.vida = 100;
		this.daño = 400;
		this.setNombre("Curandero");
	}

	public void curar() {
		this.vida = this.getVida() + 25;
	}
}
