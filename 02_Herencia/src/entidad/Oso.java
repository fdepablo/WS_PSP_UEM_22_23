package entidad;

public class Oso extends Animal{

	@Override
	public void comer(Object o) {	
		if(this == o) {
			System.out.println("Oso no come a si mismo :(");
			return;
		}
		if(o instanceof Animal) {
			Animal a = (Animal)o;
			System.out.println("Soy el oso " + this.getNombre()
			+" y me voy a comer al animal " + a.getNombre());
			double aumentoPeso = a.getPeso()/10;
			setPeso(getPeso() + aumentoPeso);
		}else {
			System.out.println("Los oso solo comemos animales");
		}
	}

}
