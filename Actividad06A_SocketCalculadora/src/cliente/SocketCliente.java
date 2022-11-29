package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {

	// IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 1042;
	public static final String IP_SERVER = "10.34.73.105";

	public static void main(String[] args) {
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in);) {

			boolean continuar = true;

			do {
				System.out.println("Introduzca la operacion a realizar: \n" + "1: Sumar\n" + "2: Restar\n"
						+ "3: Multiplicar\n" + "4: Dividir\n" + "5: Salir");
				int opcion = Integer.parseInt(sc.nextLine());
				if (opcion != 5) {
					System.out.println("Introduzca los numeros para realizar la operacion seleccionada");
					String numero1 = sc.nextLine();
					String numero2 = sc.nextLine();
					String datos = opcion + "-" + numero1 + "-" + numero2;

					Socket socketAlServidor = new Socket();
					socketAlServidor.connect(direccionServidor);
					System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
					System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

					PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
					salida.println(datos);

					System.out.println("CLIENTE: Esperando al resultado del servidor...");
					InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
					BufferedReader bf = new BufferedReader(entrada);
					String resultado = bf.readLine();
					System.out.println("CLIENTE: El resultado de la operacion es: " + resultado);
					socketAlServidor.close();
				} else {
					System.out.println("------- FINALIZANDO PROGRAMA -------------");
					continuar = false;
				}

			} while (continuar);
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la direcci�n" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}

		System.out.println("CLIENTE: Fin del programa");
	}

}