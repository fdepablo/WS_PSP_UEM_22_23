package interfaz;

public class Almacen<T,E extends Movible> {
	private T objeto1;
	private E objeto2;
	
	public void setObjeto1(T obj1) {
		this.objeto1 = obj1;
	}
	
	public T getObjeto1() {
		return this.objeto1;
	}

	public E getObjeto2() {
		return objeto2;
	}

	public void setObjeto2(E objeto2) {
		this.objeto2 = objeto2;
	}
}	
