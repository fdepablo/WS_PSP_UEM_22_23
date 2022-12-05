package controlador;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.negocio.GestorLibro;

public class SocketServidor {
	
	public static final int PUERTO = 2021;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDORA DE LIBROS     ");
		System.out.println("--------------------------------------------");
		
		//Instanciamos el gestor y el Dao de libros al principio de la app
		GestorLibro gl = new GestorLibro();		
		
		Socket socketAlCliente = null;		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);

		try (ServerSocket serverSocket = new ServerSocket()){			

			serverSocket.bind(direccion);
			
			int peticion = 0;
			
			while(true){		
				
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				
				socketAlCliente = serverSocket.accept();
				
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				HiloLibro hl = new HiloLibro(gl, socketAlCliente);
				hl.start();				
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA
}
