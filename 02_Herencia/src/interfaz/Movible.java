package interfaz;

//Una interfaz es una declaración de métodos abstractos
//Sera usada por otras clases que tendrán que implementar
//su funcionalidad
public interface Movible {
	/**
	 * Hace que el objeto se mueva a la minima velocidad posible
	 */
	public void moverseLento();
	/**
	 * Hace que el objeto se mueva a la maxima velocidad posible
	 */
	public void moverseRapido();
	/**
	 * Hace que el objeto se mueva un numero de metros pasado
	 * por parametro
	 * @param x el numero de metros que queremos mover
	 * @return la posicion actual del objetos
	 */
	public int moverse(int x);
}
