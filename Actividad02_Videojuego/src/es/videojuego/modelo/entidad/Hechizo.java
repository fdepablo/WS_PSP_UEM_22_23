package es.videojuego.modelo.entidad;

import es.videojuego.util.NumeroAleatorio;

public class Hechizo extends Arma{

	private int poderHechizo;
	
	@Override
	public int usar() {
		int danioBase = NumeroAleatorio.generarNumero(getDanioMinimo(), getDanioMaximo());
		if(this.getPersonaje() instanceof Mago) {
			Mago mago = (Mago)this.getPersonaje();
			danioBase += mago.getInteligencia();
			danioBase += poderHechizo;
		}
		int numeroAleatorioCritico = NumeroAleatorio.generarNumero(1, 100);
		if(numeroAleatorioCritico <= getPorcentajeCritico()) {
			System.out.println(getPersonaje().getNombre() + " golpe critico!");
			danioBase *= 2;
		}
		return danioBase;
	}

	public int getPoderHechizo() {
		return poderHechizo;
	}

	public void setPoderHechizo(int poderHechizo) {
		this.poderHechizo = poderHechizo;
	}
	
	

}
