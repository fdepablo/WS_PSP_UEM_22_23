package es.videojuego.modelo.entidad;

import es.videojuego.util.NumeroAleatorio;

public class Rezo extends Arma{

	private int poderCuracion;
	
	@Override
	public int usar() {
		int danioBase = NumeroAleatorio.generarNumero(getDanioMinimo(), getDanioMaximo());
		if(this.getPersonaje() instanceof Curandero) {
			Curandero curandero = (Curandero)this.getPersonaje();
			int puntosCurados = poderCuracion + curandero.getSabiduria();
			int vidaTotal = curandero.getVida() + puntosCurados;
			curandero.setVida(vidaTotal);
		}
		int numeroAleatorioCritico = NumeroAleatorio.generarNumero(1, 100);
		if(numeroAleatorioCritico <= getPorcentajeCritico()) {
			System.out.println(getPersonaje().getNombre() + " golpe critico!");
			danioBase *= 2;
		}
		return danioBase;
	}

	public int getPoderCuracion() {
		return poderCuracion;
	}

	public void setPoderCuracion(int poderCuracion) {
		this.poderCuracion = poderCuracion;
	}

	
}
