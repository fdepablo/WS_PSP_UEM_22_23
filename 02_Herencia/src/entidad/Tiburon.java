package entidad;

public class Tiburon extends Pez{

	@Override
	public void comer(Object o) {
		if(o instanceof Pez) {
			Pez p = (Pez)o;
			System.out.println("Soy el tiburon " + this.getNombre()
			+" y me voy a comer al pez " + p.getNombre());
			double aumentoPeso = p.getPeso()/10;
			setPeso(getPeso() + aumentoPeso);
		}else {
			System.out.println("Los tiburones solo comemos peces");
		}
	}

	
}
