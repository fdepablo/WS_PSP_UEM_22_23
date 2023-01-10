package modelo.entidad;

public class Poder {
	private String tipo;
	private int fuerza;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	@Override
	public String toString() {
		return "Poder [tipo=" + tipo + ", fuerza=" + fuerza + "]";
	}
	
	
}
