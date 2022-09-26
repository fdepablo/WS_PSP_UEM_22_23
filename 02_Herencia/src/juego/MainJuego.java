package juego;

public class MainJuego {
	public static void main(String[] args) {
		Guerrero g = new Guerrero();
		Arma arma = new Arco();
		g.setArma(arma);
		g.atacar();
	}
}
