package entidad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainEntidad {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.setNombre("Steve Roger");
		
		Direccion d1 = new Direccion();
		p1.setDireccion(d1);
		p1.getDireccion().setCiudad("Murcia");
		System.out.println(p1.getDireccion().getCiudad());
		d1.setCiudad("New York");
		System.out.println(p1.getDireccion().getCiudad());
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Persona p2 = new Persona();
		listaPersonas.add(p2);
		p2.setNombre("Tony Stark");
		System.out.println(listaPersonas);
		
		d1 = new Direccion();
		d1.setCiudad("Ibiza");
		
		//p2.setDireccion(d1);
		listaPersonas.get(0).setDireccion(d1);
		
		System.out.println(listaPersonas);
		
		MainEntidad.llamarFuncion();
		MainEntidad me = new MainEntidad();
		me.llamarMetodo();
		
		p1.personaEspecial = p2;
		
		String cadena1 = "Felix1";
		String cadena2 = "Felix1";
		
		if(cadena1 == cadena2) {
			System.out.println("Es igual");
		}else {
			System.out.println("Es diferente");
		}
		
		cadena1 = "Felix1";
		cadena2 = new String("Felix1");
		
		if(cadena1 == cadena2) {
			System.out.println("Es igual");
		}else {
			System.out.println("Es diferente");
		}
		
		if(cadena1.equals(cadena2)) {
			System.out.println("Es igual");
		}else {
			System.out.println("Es diferente");
		}
	}
	
	public static void llamarFuncion() {
		System.out.println("Funcion llamada");
	}
	
	public void llamarMetodo() {
		System.out.println("Metodo llamado");
		this.llamarMetodo2();
	}
	
	public void llamarMetodo2() {
		System.out.println("Metodo 2 llamado");
	}

}
