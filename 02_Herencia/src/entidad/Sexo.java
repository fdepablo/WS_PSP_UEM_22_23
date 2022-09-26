package entidad;

//Es un tipo especial de clase en el que los objetos
//se crean cuando se arranca el programa, y no 
//puede haber más de los que se declaran dentro del 
//enumerado
public enum Sexo {
	MACHO(1),HEMBRA(2),HEMAFRODITA(3);
	//Vamos a tener 3 objetos Sexo que seran estos
	
	private int numeroGonadas;
	
	private Sexo(int numeroGonadas) {
		this.numeroGonadas = numeroGonadas;
	}
}
