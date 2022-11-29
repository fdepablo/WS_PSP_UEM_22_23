package Personajes;

import Juego.Batalla;

public class Personaje implements Runnable {
	protected double vida;
	protected double daño;
	private Batalla batalla;

	public Batalla getBatalla() {
		return batalla;
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}

	private String nombre;

	public double getDaño() {
		return daño;
	}

	public void setDaño(double daño) {
		this.daño = daño;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getVida() {
		return vida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setVida(Double vida) {
		this.vida = vida;
	}

	public void atacar(Personaje rival) {
		if (this instanceof FinalBoss) {
			if (rival.vida > 0 && this.vida > 0) {
				rival.setVida(rival.getVida() - this.getDaño());
				if (rival.getVida() > 0) {
					System.out.println("El boss le ha quitado " + this.getDaño() + " a " + rival.getNombre()
							+ " ||| HP " + rival.getNombre() + " : " + rival.getVida());
				} else {
					System.out
							.println(this.getNombre() + " le ha quitado " + this.getDaño() + " a " + rival.getNombre());
					System.out
							.println("\nEl " + rival.getNombre() + " ha muerto. Es el turno del siguiente personaje\n");
				}
			}

		} else {
			if (this.vida > 0) {
				rival.setVida(rival.getVida() - this.getDaño());
				System.out.println(this.getNombre() + " le ha quitado " + this.getDaño() + " a " + rival.getNombre()
						+ " ||| HP " + rival.getNombre() + " : " + rival.getVida());
			}

			if (rival.vida <= 0) {
				System.out.println("\nHas matado al boss. El nuevo campeón es: " + this.getNombre() + "\n");
				batalla.setVencedor(this.getNombre());
			}
		}
	}

	@Override
	public void run() {
		batalla.iniciarPelea(this);
	}

}
