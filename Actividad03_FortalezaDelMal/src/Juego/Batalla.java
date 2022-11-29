package Juego;

import Personajes.FinalBoss;
import Personajes.Personaje;

public class Batalla {
	private String vencedor = "";
	private FinalBoss boss;

	public Batalla(FinalBoss boss) {
		this.boss = boss;
	}

	public synchronized void iniciarPelea(Personaje p) {
		while (p.getVida() > 0 && boss.getVida() > 0) {
			p.atacar(boss);
			boss.atacar(p);
		}
		if (boss.getVida() <= 0 && !vencedor.equals(p.getNombre())) {
			System.out.println(p.getNombre() + " dice: " + "'¡Vaya! Parece que el " + vencedor
					+ " ha matado al jefe... Pues GG!'");
		}
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String campeon) {
		vencedor = campeon;
	}
}
