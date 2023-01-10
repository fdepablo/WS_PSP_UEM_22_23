package modelo.entidad;

public class SuperHeroe {
	private String nombre;
	private Poder poder;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Poder getPoder() {
		return poder;
	}
	public void setPoder(Poder poder) {
		this.poder = poder;
	}
	@Override
	public String toString() {
		return "SuperHeroe [nombre=" + nombre + ", poder=" + poder + "]";
	}
	
	
}
