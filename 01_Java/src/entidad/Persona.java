package entidad;

//Una estructura JavaBean es una clase simple que
//tiene atributos privados y setters y getter 
//publicos
public class Persona {
	private String nombre;
	private int edad;
	private double peso;
	private Direccion direccion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		if(edad >= 0)
			this.edad = edad;
		else
			this.edad = 0;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", direccion=" + direccion + "]";
	}
	
	
}
