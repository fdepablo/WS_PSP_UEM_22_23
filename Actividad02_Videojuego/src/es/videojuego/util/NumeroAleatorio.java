package es.videojuego.util;

public class NumeroAleatorio {
	
	public static int generarNumero(int min, int max) {
		int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
		return randomWithMathRandom;//ty baeldung :)
	}
}
