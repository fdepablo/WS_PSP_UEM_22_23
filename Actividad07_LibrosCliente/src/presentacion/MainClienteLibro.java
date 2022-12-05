package presentacion;

import modelo.entidad.Libro;
import modelo.negocio.ServicioProxyLibro;

public class MainClienteLibro {
	//Aqui habría que hacer el menu de conexión con el cliente
	public static void main(String[] args) {
		//Cliente	
		
		Libro libro = new Libro();
		libro.setISBN("1234");
		libro.setAutor("Felix");
		libro.setPrecio(200);
		libro.setTitulo("Como hacer un app del tiron :) :)");
		
		ServicioProxyLibro spl = new ServicioProxyLibro();
		boolean alta = spl.alta(libro);
		
		
		Libro libro2 = spl.obtenerLibroPorIsbn("1234");
		
		System.out.println(libro2);
		
		libro2 = spl.obtenerLibroPorIsbn("4321");
		
		System.out.println(libro2);
		
		System.out.println(spl.obtenerLibroPorAutor("Felix"));
		
	}
}
