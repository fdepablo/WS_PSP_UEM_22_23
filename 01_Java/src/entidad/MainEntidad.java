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
	}

}
