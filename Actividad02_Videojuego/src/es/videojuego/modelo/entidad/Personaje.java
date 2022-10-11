package es.videojuego.modelo.entidad;

public abstract class Personaje {
	private String nombre;
	private int vida;
	private Arma arma;
	
	public int atacar(Personaje p) {
		int danio = getArma().usar();
		int vidaRestante = p.getVida() - danio;
		p.setVida(vidaRestante);
		return danio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}	
	
	public boolean estaMuerto() {
		if(getVida() <= 0) {
			System.out.println(".." + this.nombre + " me muerooooooooooooo arrrggggggg........");
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", vida=" + vida + "]";
	}	
}
