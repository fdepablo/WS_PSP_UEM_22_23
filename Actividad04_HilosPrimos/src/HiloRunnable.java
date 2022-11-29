public class HiloRunnable implements Runnable {
	private Calculador cc;
	private int numero;

	public HiloRunnable(Calculador cc, int numero) {
		this.cc = cc;
		this.numero = numero;
	}

	@Override
	public void run() {
		long inicio = System.currentTimeMillis();
		if (cc.esPrimo(numero)) {
			System.out.println("El numero: " + numero + " es primo");
		} else {
			System.out.println("El numero: " + numero + " no es primo");
		}
		double tiempo = (System.currentTimeMillis() - inicio);
		System.out.println("El hilo: " + Thread.currentThread().getName() + " ha tardado: " + tiempo + " mili segundos");
	}
}
