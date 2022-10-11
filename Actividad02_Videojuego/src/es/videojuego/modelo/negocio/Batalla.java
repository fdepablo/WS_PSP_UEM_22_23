package es.videojuego.modelo.negocio;

import java.util.List;
import java.util.Scanner;

import es.videojuego.modelo.entidad.Personaje;
import es.videojuego.util.NumeroAleatorio;

public class Batalla {
	private Personaje p1;
	private Personaje p2;

	public Personaje combatir() {
		Personaje pInicial = null;
		Personaje pFinal = null;
		Personaje pGanador = null;
		int turno = 1;
		
		Scanner sc = new Scanner(System.in);
		
		int moneda = NumeroAleatorio.generarNumero(1, 2);
		if(moneda == 1) {
			pInicial = p1;
			pFinal = p2;
		}else {
			pInicial = p2;
			pFinal = p1;
		}
		
		System.out.println("COMIENZA LA BATALLA POR LA LUCHA DEL MEJOR COMBATIENTE DEL REINO");
		System.out.println("Personaje Inicial: " + pInicial + " con el arma " + pInicial.getArma());
		System.out.println("Personaje Final " + pFinal + " con el arma " + pFinal.getArma());

		sc.nextLine();
		boolean combateAcabado = false;
		
		do {
			System.out.println("TURNO: " + turno++);
			int danio = pInicial.atacar(pFinal);
			logBatalla(pInicial, pFinal, danio);
			if(pFinal.estaMuerto()) {
				pGanador = pInicial;
				combateAcabado = true;
			}else {
				danio = pFinal.atacar(pInicial);
				logBatalla(pFinal, pInicial, danio);
				if(pInicial.estaMuerto()) {
					pGanador = pFinal;
					combateAcabado = true;
				}
			}
			System.out.println(pInicial);
			System.out.println(pFinal);
			sc.nextLine();
		}while(!combateAcabado);
		
		return pGanador;
	}
	
	public void logBatalla(Personaje p1, Personaje p2, int danio) {
		System.out.println("El personaje " 
				+ p1.getNombre() + " ha hecho " 
				+ danio + " al personaje " + p2.getNombre());
	}

	public Personaje getP1() {
		return p1;
	}


	public void setP1(Personaje p1) {
		this.p1 = p1;
	}


	public Personaje getP2() {
		return p2;
	}


	public void setP2(Personaje p2) {
		this.p2 = p2;
	}
	
}
