package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Libro;

public class DaoLibro {
	private static List<Libro> listaLibros;
	
	static {

		listaLibros = new ArrayList<>();
		Libro libro = new Libro();
		libro.setISBN("4321");
		libro.setAutor("Pepe");
		libro.setPrecio(45);
		libro.setTitulo("El chavo del ocho");
		
		listaLibros.add(libro);

	}

	public Libro buscarPorIsbn(String isbn) {
		Libro libro = null;
		
		for(Libro l : listaLibros) {
			if(l.getISBN().equalsIgnoreCase(isbn)) {
				libro = l;
				break;
			}
		}
		
		return libro;
	}
	
	public Libro buscarPorTitulo(String titulo) {
		Libro libro = null;
		
		for(Libro l : listaLibros) {
			if(l.getTitulo().equalsIgnoreCase(titulo)) {
				libro = l;
				break;
			}
		}
		
		return libro;
	}
	
	public List<Libro> buscarPorAutor(String autor) {
		List<Libro> listaLibrosAux = new ArrayList<Libro>();
		
		for(Libro l : listaLibros) {
			if(l.getAutor().equalsIgnoreCase(autor)) {
				listaLibrosAux.add(l);
			}
		}
		
		return listaLibrosAux;
	}
	
	public boolean addLibro(Libro l) {
		return listaLibros.add(l);
	}
}
