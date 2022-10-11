package es.videojuego.modelo.entidad;

import es.videojuego.util.NumeroAleatorio;

public class Arco extends Arma{

	@Override
	public int usar() {
		int danioBase = NumeroAleatorio.generarNumero(getDanioMinimo(), getDanioMaximo());
		if(this.getPersonaje() instanceof Guerrero) {
			Guerrero guerrero = (Guerrero)this.getPersonaje();
			danioBase += guerrero.getFuerza();
		}
		int numeroAleatorioCritico = NumeroAleatorio.generarNumero(1, 100);
		if(numeroAleatorioCritico <= getPorcentajeCritico()) {
			System.out.println(getPersonaje().getNombre() + " golpe critico!");
			danioBase *= 3;
		}
		return danioBase;
	}

}
