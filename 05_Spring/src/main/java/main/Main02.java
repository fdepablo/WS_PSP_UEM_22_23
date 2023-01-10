package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Persona;
import modelo.entidad.SuperHeroe;

public class Main02 {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("Context2.xml");

		SuperHeroe sh1 = context.getBean("dr_strange",SuperHeroe.class);
		
		System.out.println(sh1);
		
		SuperHeroe sh2 = context.getBean("shProto",SuperHeroe.class);
	}

	
	
}
