import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculador cc = new Calculador();
		int numeros[] = new int[3];
		for (int i = 0; i < 3; i++) {
			System.out.print("Introduce el numero " + (i + 1) + ": ");
			numeros[i] = sc.nextInt();
		}
		HiloRunnable hr1 = new HiloRunnable(cc, numeros[0]);
		Thread tr1 = new Thread(hr1);
		tr1.setName("hilo1");
		HiloRunnable hr2 = new HiloRunnable(cc, numeros[1]);
		Thread tr2 = new Thread(hr2);
		tr2.setName("hilo2");
		HiloRunnable hr3 = new HiloRunnable(cc, numeros[2]);
		Thread tr3 = new Thread(hr3);
		tr3.setName("hilo3");
		tr1.start();
		tr2.start();
		tr3.start();
		sc.close();
	}
}
