package juego;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainJuego {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("Context3.xml");
		
		Guerrero g = context.getBean("guerrero", Guerrero.class);
		Arma arma = context.getBean("arma", Arma.class);
		g.setArma(arma);
		g.atacar();
		
		Guerrero l = context.getBean("legolas", Guerrero.class);
		l.atacar();
	}
}
