package main;

import java.util.ArrayList;
import java.util.List;

import entidad.Animal;
import entidad.Oso;
import entidad.Placton;
import entidad.Sexo;
import entidad.Tiburon;
import entidad.Trucha;

public class MainHerencia {
	
	//var atributo1 = new String();
	
	public static void main(String[] args) {
		Animal a = null;
		a = new Trucha();
		a.setNombre("Calamarda");
		a.setPeso(20);
		a.setSexo(Sexo.HEMBRA);
		Trucha t = (Trucha)a;
		t.setNumeroAletas(4);
		
		Tiburon tiburon = new Tiburon();
		tiburon.setNombre("Arenita");
		tiburon.setNumeroAletas(6);
		tiburon.setPeso(400);
		tiburon.setSexo(Sexo.HEMAFRODITA);
		
		Oso oso = new Oso();
		oso.setNombre("Yogi");
		oso.setPeso(350);
		oso.setSexo(Sexo.MACHO);
		
		List<Animal> listaAnimales = new ArrayList<Animal>();
		listaAnimales.add(t);
		listaAnimales.add(tiburon);
		listaAnimales.add(oso);
		
		Placton p = new Placton();
		p.setCalorias(1000);
		
		for(Animal animal : listaAnimales) {
			animal.comer(p);
			System.out.println(animal.getPeso());
		}
		
		Trucha tAlimento = new Trucha();
		tAlimento.setPeso(10);
		tAlimento.setNombre("Coral");
		
		listaAnimales.forEach(animal -> {
			animal.comer(tAlimento);
			System.out.println(animal.getPeso());
		});
		
		Oso tAlimentoOso = oso;
		listaAnimales.forEach(animal -> {
			animal.comer(tAlimentoOso);
			System.out.println(animal.getPeso());
		});
		
		
		//Las clases anonimas es cuando creamos la clase
		//y el objeto a la vez. Se llama clase anomima
		//porque nunca se podrá crear otra vez esa misma
		//clase
		
		Animal animal = new Animal() {
			
			@Override
			public void comer(Object o) {
				if(o instanceof Trucha) {
					System.out.println("Soy un leon  y voy "
							+ "a comer una truca :) :)");
				}
			}
		};
		
		animal.comer(t);
		
		var animal4 = new Tiburon();
		Tiburon t6 = animal4;
		String s;
		var prueba1 = prueba(5);

	}
	
	public static Integer prueba(int numero) {
		if(numero >0) {
			return numero;
		}else {
			return null;
		}
		
	}
}
