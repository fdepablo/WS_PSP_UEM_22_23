package Juego;

import Personajes.Curandero;
import Personajes.FinalBoss;
import Personajes.Guerrero;
import Personajes.Mago;
import Personajes.Personaje;

public class Test {

	public static void main(String[] args) {
		Personaje curandero1 = new Curandero();
		Personaje mago1 = new Mago();
		Personaje guerrero1 = new Guerrero();
		FinalBoss bowser = new FinalBoss();

		/**
		 * Hilos h1 = new Hilos(curandero1, bowser); Hilos h2 = new Hilos(mago1,
		 * bowser); Hilos h3 = new Hilos(guerrero1, bowser);
		 */

		Batalla batalla = new Batalla(bowser);
		mago1.setBatalla(batalla);
		curandero1.setBatalla(batalla);
		guerrero1.setBatalla(batalla);

		new Thread(mago1).start();
		new Thread(guerrero1).start();
		new Thread(curandero1).start();

	}

}