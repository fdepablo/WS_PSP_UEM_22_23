package clases;

public class Persona {
	//private, solo desde la clase
	private String nombre;
	//default, desde clase y desde las clases dentro 
	//del mismo paquete
	int edad;
	//protected, desde clase, desde las clases dentro del mismo
	//paquete, y las clases que hereden de esta
	protected String apellidos;
	public String direccion;
	
	public Persona() {
		this.nombre = "";
	}
}
