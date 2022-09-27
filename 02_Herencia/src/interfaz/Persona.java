package interfaz;

import java.io.Serializable;

//Una clase solo puede heredar de otra, pero podemos
//implementar todas las interfaces que queramos
public class Persona implements Movible, Serializable{

	//Es una interfaz de marcado que permite sacar objetos
	//de la JVM
	private static final long serialVersionUID = -6283079558545836649L;
	
	private int posicion;
	private String nombre;
	private int velocidadMax;
	
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void moverseLento() {
		this.posicion++;
	}
	@Override
	public void moverseRapido() {
		this.posicion += this.velocidadMax;
	}
	
	@Override
	public int moverse(int x) {
		if(x >= this.velocidadMax) {
			this.posicion += this.velocidadMax;
		}else {
			this.posicion += x;
		}
		
		return this.posicion;
	}
	public int getVelocidadMax() {
		return velocidadMax;
	}
	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}
	
	
}
