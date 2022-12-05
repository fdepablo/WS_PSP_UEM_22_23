package modelo.negocio;

import java.util.List;

import modelo.entidad.Libro;
import modelo.persistencia.DaoLibro;

public class GestorLibro {

	private DaoLibro daoLibro = new DaoLibro();
	
	public Libro getLibroByISBN(String isbn) {
		return daoLibro.buscarPorIsbn(isbn);
	}
	
	public Libro getLibroByTitulo(String titulo) {
		return daoLibro.buscarPorTitulo(titulo);
	}
	
	public List<Libro> getLibrosByAutor(String autor){
		return daoLibro.buscarPorAutor(autor);
	}
	
	public synchronized boolean addLibro(Libro libro) {
		return daoLibro.addLibro(libro);
	}
}
