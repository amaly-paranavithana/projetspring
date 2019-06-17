package appTest;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.*;
import metier.*;
import repository.*;


public class AppTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("application-context.xml");
		
		ctx.close();

	}

}
