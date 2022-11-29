package Juego;

import Personajes.FinalBoss;
import Personajes.Personaje;

public class Hilos implements Runnable {
	private Personaje personaje;
	private FinalBoss bossFinal;

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Hilos(Personaje p, FinalBoss boss) {
		this.personaje = p;
		this.bossFinal = boss;
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		//Batalla.iniciarPelea(personaje, bossFinal);
	}
}
