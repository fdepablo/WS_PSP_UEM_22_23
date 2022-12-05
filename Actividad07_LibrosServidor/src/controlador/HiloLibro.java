package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

import modelo.entidad.Libro;
import modelo.negocio.GestorLibro;

public class HiloLibro extends Thread {
	private GestorLibro gestorLibro;
	private Socket socketAlCliente;
	
	public HiloLibro(GestorLibro gestorLibro, Socket socketAlCliente) {
		this.gestorLibro = gestorLibro;
		this.socketAlCliente = socketAlCliente;
	}

	@Override
	public void run() {
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;
		
		try {
			//Salida del servidor al cliente
			salida = new PrintStream(socketAlCliente.getOutputStream());
			//Entrada del servidor al cliente
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			entradaBuffer = new BufferedReader(entrada);
			
			String texto = "";			

			texto = entradaBuffer.readLine();

			//Vamos a tener 4 tipos de ordenes diferentes
			//1- Consultar libro por isbn (1-345)
			//2- Consultar libro por titulo (2-El señor de las moscas)
			//3- Consultar libros por autor (3-tolkien)
			//4- Alta libro (4-1234-el Quijote-cervantes-20)

			String[] datos = texto.split("-");
			String codigoPeticion = datos[0];
			String textoRespuesta = "";
			Libro libro = null;
			
			switch (codigoPeticion) {
			case "1":
				String isbn = datos[1];
				libro = gestorLibro.getLibroByISBN(isbn);
				textoRespuesta = serializarLibro(libro);
				break;
			case "2":
				String titulo = datos[1];
				libro = gestorLibro.getLibroByTitulo(titulo);
				textoRespuesta = serializarLibro(libro);		
				break;
			case "3":
				String autor = datos[1];
				List<Libro> listaLibros = gestorLibro.getLibrosByAutor(autor);
				textoRespuesta = serializarLibros(listaLibros);
				break;
			case "4":
				libro = deserializarLibro(datos);
				boolean respuesta = gestorLibro.addLibro(libro);
				textoRespuesta = String.valueOf(respuesta);
				break;
			default:
				textoRespuesta = "0";
				break;
			}
			
			salida.println(textoRespuesta);
			
			//Cerramos el socket
			socketAlCliente.close();
		} catch (IOException e) {
			System.err.println("HiloContadorLetras: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("HiloContadorLetras: Error");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que deserializa un array de string con la información del libro
	 * con el siguiente formato:
	 * posicion 1 del array: isbn
	 * posicion 2 del array: titulo
	 * posicion 3 del array: autor
	 * posicion 4 del array: precio
	 * @param array de strings con la información del libro a desserializar
	 * @return un objeto libro
	 */
	private Libro deserializarLibro(String[] datos) {
		Libro libro = new Libro();
		libro.setISBN(datos[1]);
		libro.setTitulo(datos[2]);
		libro.setAutor(datos[3]);
		String sPrecio = datos[4];
		double precio = Double.parseDouble(sPrecio);
		libro.setPrecio(precio);
		
		return libro;
	}

	/**
	 * Metodo que serializa un libro con el siguiente formato:
	 * ISBN-TITULO-AUTOR-PRECIO
	 * @param libro el libro a serializar
	 * @return string con el formato "ISBN-TITULO-AUTOR-PRECIO"
	 */
	public String serializarLibro(Libro libro) {
		String libroSerializado = "";
		libroSerializado+=libro.getISBN();
		libroSerializado+="-";
		libroSerializado+=libro.getTitulo();
		libroSerializado+="-";
		libroSerializado+=libro.getAutor();
		libroSerializado+="-";
		libroSerializado+=libro.getPrecio();
		return libroSerializado;
	}
	
	/**
	 * Metodo que serializa una lista de libros con el siguiente formato
	 * ISBN-TITULO-AUTOR-PRECIO*ISBN-TITULO-AUTOR-PRECIO*ISBN-TITULO-AUTOR-PRECIO..
	 * @param listaLibros
	 * @return
	 */
	private String serializarLibros(List<Libro> listaLibros) {
		String librosSerializados = "";
		for(Libro l : listaLibros) {
			librosSerializados+=serializarLibro(l);
			librosSerializados+="*";
		}
		//Eliminamos el ultimo "*"
		String librosSerializadoFinal = 
				librosSerializados.substring(0, librosSerializados.length());
		return librosSerializadoFinal;
	}
}
