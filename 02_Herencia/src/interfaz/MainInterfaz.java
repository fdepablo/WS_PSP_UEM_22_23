package interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainInterfaz {
	public static void main(String[] args) {
		Movible m = new Caballo();
		Movible m2 = new Persona();
		
		List<Movible> listaMovible = new ArrayList<Movible>();
		listaMovible.add(m);
		listaMovible.add(m2);		
		
		Persona p = (Persona)m2;
		p.setNombre("Gilitot");
		p.setVelocidadMax(10);
				
		for(Movible m3 : listaMovible) {
			m3.moverseLento();
			int posicion = m3.moverse(20);
			System.out.println("El objeto " + m3.getClass().getName() +
			" esta en la posición " + posicion);
		}
		
		Movible m4 = new Movible() {
			
			@Override
			public void moverseRapido() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void moverseLento() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int moverse(int x) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		Operacion op = new Operacion() {
			
			@Override
			public int operar(int n1, int n2) {
				return n1 + n2;
			}
		};
		
		System.out.println(op.operar(3, 4));
		System.out.println(op.operar(6, 7));
		
		op = new Operacion() {			
			@Override
			public int operar(int n1, int n2) {
				return n2 -n1;
			}
		};
		
		System.out.println(op.operar(3, 4));
		System.out.println(op.operar(6, 7));
		
		//Java decidio implementar las funciones lambda
		//a partir de la version 1.8, y su objetivo
		//era simplificar las clases anonimas creadas
		//a partir de una interfaz. Así pues podemos
		//usar funciones lambda en vez de clases anonimas
		//siempre y cuando la interfaz sea una interfaz
		//funcional. Una IF es una interfaz con UN unico
		//metodo abstracto
		
		// una interfaz lambda lo que busca es emular la
		//programación funcional que no tenia java antes
		//de la version 1.8. La unica manera que tenia
		//java de emular la programación funcional era
		//mediante interfaces funcionales
		
		//Una funcion lambda tiene la siguiente estructura
		// (parametroEntrada) -> { CODIGO }
		
		Operacion opLambda = (n1, n2) -> {return n1 + n2;};
		System.out.println(opLambda.operar(3, 4));
		System.out.println(opLambda.operar(6, 7));
		
		opLambda = (n1, n2) -> {return n2 - n1;};
		System.out.println(opLambda.operar(3, 4));
		System.out.println(opLambda.operar(6, 7));
		
		opLambda = (n1, n2) -> {return n1 / n2;};
		System.out.println(opLambda.operar(4, 2));
		//System.out.println(opLambda.operar(4, 0));
		
		//Si poneis una solo sentencia no hace falta ni poner "return"
		OperacionGenerica<Double> opDouble = (n1, n2) -> n1 / n2;
		OperacionGenerica<Integer> opInteger = (n1, n2) -> n1 / n2;
		
		System.out.println(opDouble.operar(4.0, 2.0));
		System.out.println(opDouble.operar(4.0, 0.0));
		
		System.out.println(opInteger.operar(4, 2));
		System.out.println(opInteger.operar(4, 0));
		
		Almacen<Operacion, Movible> almacenOp = new Almacen<Operacion, Movible>();
		almacenOp.setObjeto1(opLambda);
		almacenOp.setObjeto2(p);
		
		Consumer<Movible> c = new Consumer<Movible>() {
			
			@Override
			public void accept(Movible t) {
				System.out.println(t);
				
			}
		};
		
		listaMovible.forEach(v -> System.out.println(v));
		listaMovible.forEach(c);
		
		Function<Double, Double> operCuadrado =
				(n1) -> n1*n1;
		//Bifunction es igual que OperacionGenerica
		BiFunction<Double, Double, Double> operDivi =
				(n1,n2) -> n2/n1;
	}
}
