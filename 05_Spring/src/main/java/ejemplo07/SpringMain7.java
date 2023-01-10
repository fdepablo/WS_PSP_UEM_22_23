package ejemplo07;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain7 {
	public static ApplicationContext context = null;
		
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("Context4.xml");
		
		List<String> listaNombres = 
				context.getBean("listaNombres",List.class);
		
		for(String s : listaNombres) {
			System.out.println(s);
		}
		
		System.out.println("**********************************");
		List<Persona> listaPersonas = 
				context.getBean("listaPersonas",List.class);
		
		//Podemos recorrear arrays usando expresiones lambda
		listaPersonas.forEach((v) -> {
			System.out.println(v);
		});
		
		System.out.println("**********************************");
		Map<Integer, Persona> mapaPersonas = 
				context.getBean("mapaPersonas",Map.class);
		
		System.out.println(mapaPersonas.get(1));
		System.out.println(mapaPersonas.get(2));
		
		//Podemos usar expresiones lambda para recorrer mapas
		mapaPersonas.forEach((k,v) -> {
			System.out.println("Key: " + k + ": Value: " + v);
		});
		
		System.out.println("**********************************");
		Set<Persona> conjuntoPersonas = 
				context.getBean("conjuntoPersonas",Set.class);
		
		conjuntoPersonas.forEach((v) -> {
			System.out.println(v);
		});
		
		System.out.println("******** Objeto Colecciones **************");
		Colecciones colecciones = 
				context.getBean("colecciones",Colecciones.class);

		
		colecciones.getListaPersonas().forEach((v) -> {
			System.out.println(v);
		});
		
		colecciones.getConjuntoStrings().forEach((v) -> {
			System.out.println(v);
		});
		
		colecciones.getMapaPersonas().forEach((k,v) -> {
			System.out.println("Key: " + k + ": Value: " + v);
		});
	}
}
