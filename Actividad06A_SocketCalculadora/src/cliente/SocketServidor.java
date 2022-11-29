package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

	public static final int PUERTO = 1042;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");

		InputStreamReader entrada = null;

		PrintStream salida = null;

		Socket socketAlCliente = null;

		InetSocketAddress direccion = new InetSocketAddress(PUERTO);

		try (ServerSocket serverSocket = new ServerSocket()) {

			serverSocket.bind(direccion);

			int peticion = 0;

			while (true) {

				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);

				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");

				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);

				String stringRecibido = bf.readLine();
				String[] valores = stringRecibido.split("-");
				double[] valoresNumericos = new double[valores.length];
				for (int i = 0; i < valores.length; i++) {
					valoresNumericos[i] = Integer.parseInt(valores[i]);
				}
				double resultado = 0;

				switch ((int) valoresNumericos[0]) {
				case 1:
					resultado = suma(valoresNumericos[1], valoresNumericos[2]);
					break;
				case 2:
					resultado = resta(valoresNumericos[1], valoresNumericos[2]);
					break;
				case 3:
					resultado = multiplicacion(valoresNumericos[1], valoresNumericos[2]);
					break;
				case 4:
					resultado = division(valoresNumericos[1], valoresNumericos[2]);
					break;
				}

				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);

				// Hay que tener en cuenta que es posible que los servidores tarden en responder
				// Thread.sleep(15000);

				// Es en este momento cuando calculamos la suma

				System.out.println("SERVIDOR: El calculo de los numeros es: " + resultado);

				// Mandamos el resultado al cliente
				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultado);

				// Si hemos llegado hasta aqui, cerramos las conexiones
				socketAlCliente.close();
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}// FIN DEL PROGRAMA

	private static double suma(double x, double y) {
		return x + y;
	}

	private static double resta(double x, double y) {
		return x - y;
	}

	private static double division(double dividendo, double divisor) {
		return dividendo / divisor;
	}

	private static double multiplicacion(double x, double y) {
		return x * y;
	}

}