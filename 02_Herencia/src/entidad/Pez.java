package entidad;

public abstract class Pez extends Animal{
	private int numeroAletas;

	@Override
	public void comer(Object o) {
		if(o instanceof Placton) {
			System.out.println("Soy el pez " + this.getNombre()
			+ " de tipo " + this.getClass().getSimpleName() +" y voy a comer placton");
			Placton p = (Placton)o;
			double aumentoPeso = p.getCalorias()/1000;
			setPeso(getPeso() + aumentoPeso); 
		}else {
			System.out.println("Soy un pez y solo como placton");
		}
		
	}

	public int getNumeroAletas() {
		return numeroAletas;
	}

	public void setNumeroAletas(int numeroAletas) {
		this.numeroAletas = numeroAletas;
	}	
}
