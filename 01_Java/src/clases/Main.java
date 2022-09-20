package clases;

public class Main {
	public static void main(String[] args) {
		System.out.println("Bienvenidos");
		new Persona();
		System.out.println("Creeis que este objeto vive?");
		Persona p1 = new Persona();
		p1.edad = 5;
		Persona p2 = new Persona();
		p2.edad = 7;
		
		Persona p3 = p1; 
				
		p1 = p2;
		p2.edad = 10;
		System.out.println(p1.edad);
		System.out.println(p2.edad);//10 10 ; 7 7 ; 7 10
		
		{
			Persona p4 = new Persona();
			p4.edad = 17;
		}
		//
		//p4.edad = 14;
		cambiarEdad(p2);
		System.out.println(p2.edad);
		System.out.println(p1.edad);
		
		int numero = 5;
		cambiarNumero(numero);
		System.out.println(numero);
		
		int cp = 28224;
		System.out.println(cp);
		cp = 03540;//los numeros en java que empiezan por 0
		//no estan en base decimal, estan en base octal
		System.out.println(cp);
		//los numeros en java que empiezan por 0x, estan en base
		//hexadecimos
		cp = 0xFF;
		System.out.println(cp);
		//los numeros en java que empiezan por 0b son en binario
		cp = 0b101;
		System.out.println(cp);
		
		long numero2 = 1_100_000_000_000L;
	}
	
	public static void cambiarEdad(Persona p1) {
		p1.edad = 20;		
	}
	
	public static void cambiarNumero(int numero1) {
		numero1 = 10;
	}
}
