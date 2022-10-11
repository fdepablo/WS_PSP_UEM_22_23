package es.videojuego.main;

import es.videojuego.modelo.entidad.Curandero;
import es.videojuego.modelo.entidad.Hechizo;
import es.videojuego.modelo.entidad.Mago;
import es.videojuego.modelo.entidad.Personaje;
import es.videojuego.modelo.entidad.Rezo;
import es.videojuego.modelo.negocio.Batalla;

public class Main {
	public static void main(String[] args) {
		Mago mago = new Mago();
		mago.setInteligencia(10);
		mago.setNombre("Gandalf");
		mago.setVida(200);
		
		Hechizo bolaDeFuego = new Hechizo();
		bolaDeFuego.setDanioMinimo(10);
		bolaDeFuego.setDanioMaximo(20);
		bolaDeFuego.setPorcentajeCritico(20);
		bolaDeFuego.setPoderHechizo(10);
		
		//ahora viene la bidercionalidad
		mago.setArma(bolaDeFuego);
		bolaDeFuego.setPersonaje(mago);
		
		Curandero cu = new Curandero();
		cu.setNombre("Saruman");
		cu.setSabiduria(10);
		cu.setVida(200);
		
		Rezo rezo = new Rezo();
		rezo.setDanioMaximo(20);
		rezo.setDanioMinimo(10);
		rezo.setPorcentajeCritico(20);
		rezo.setPoderCuracion(10);
		
		//ahora viene la bidercionalidad
		cu.setArma(rezo);
		rezo.setPersonaje(cu);
		
		Batalla batalla = new Batalla();
		batalla.setP1(mago);
		batalla.setP2(cu);
		
		Personaje pGanador = batalla.combatir();
		System.out.println("El ganador de la arena es!!!!!: " + pGanador);
	}
}
