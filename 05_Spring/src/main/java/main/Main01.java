package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Persona;

public class Main01 {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Context1.xml");

		System.out.println("contexto arrancado");
		
		//podemos pedir los objetos al contexto de spring y castearlos
		Persona p1 = (Persona)context.getBean("persona1");
		p1.setNombre("Banana Joe");
		
		//O que nos lo castee spring en su lugar
		Persona p2 = context.getBean("persona1", Persona.class);
		System.out.println(p2);
		
		mostrarPersona();
		
		//Persona p3 = new Persona();
		//p3.setNombre("Pikolo");
		
		Persona p4 = context.getBean("goku",Persona.class);
		System.out.println(p4);
		
		Persona p5 = context.getBean("personaPrototype",Persona.class);
		p5.setNombre("Vegeta");
		System.out.println(p5);
		
		Persona p6 = context.getBean("personaPrototype",Persona.class);
		System.out.println(p6);
		
		List<Persona> listaPersonas = context.getBean("listaPersonas", List.class);
		listaPersonas.add(p5);
		listaPersonas.add(p6);
		
		System.out.println("--------------");
		listaPersonas.forEach(v -> System.out.println(v));
		
		Persona p7 = context.getBean("personaConstructor", Persona.class);
		System.out.println(p7);
	}

	
	private static void mostrarPersona() {
		Persona p1 = context.getBean("persona1",Persona.class);
		System.out.println(p1);
	}
}
