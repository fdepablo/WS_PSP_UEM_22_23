package ejemplo07;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Colecciones {
	//Coleccion ordenada de elementos. Admite repeticion
	private List<Persona> listaPersonas;
	//Coleccion NO ordenada de elementos. No admite repeticion
	private Set<String> conjuntoStrings;
	//Estructura de datos de tipo clave-valor. La cual el valor se
	//guarda o se asocia a traves de una clave. Tiene una estructura 
	//bidimensional
	private Map<Integer,Persona> mapaPersonas;
	
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	public Set<String> getConjuntoStrings() {
		return conjuntoStrings;
	}
	public void setConjuntoStrings(Set<String> conjuntoStrings) {
		this.conjuntoStrings = conjuntoStrings;
	}
	public Map<Integer, Persona> getMapaPersonas() {
		return mapaPersonas;
	}
	public void setMapaPersonas(Map<Integer, Persona> mapaPersonas) {
		this.mapaPersonas = mapaPersonas;
	}
	
	
}
