package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.Film;
import metier.Realisateur;
import service.FilmService;

public class TestAmy {

	public static void main(String[] args) throws ParseException {
		testInsertFilm();
	}
	
	public static void testInsertFilm() throws ParseException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		FilmService serv = ctx.getBean(FilmService.class);
		
		Film f1 =new Film();
		f1.setTitre("Avatar");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		f1.setDate(sdf.parse("16/12/2009"));
		serv.insert(f1);
		
		ctx.close();
	}
	
		public static void testfindById() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		FilmService serv = ctx.getBean(FilmService.class);
		
		System.out.println(serv.findById(1));
		ctx.close();
	}
	
	public void testfindByTitre() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		FilmService serv = ctx.getBean(FilmService.class);
	
		System.out.println(serv.findByTitre("Avatar"));
		ctx.close();
	}
	
	public void testfindByDate() throws ParseException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		FilmService serv = ctx.getBean(FilmService.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(serv.findByDate(sdf.parse("16/12/2009")));
		ctx.close();
	}
	
	public void testAddRealisateur () {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		FilmService serv = ctx.getBean(FilmService.class);

		Realisateur r1 = new Realisateur();
		r1.setPrenom("James");
		r1.setNom("Cameron");
		
		Film f1 = serv.findById(1);
		serv.addRealisateur(f1, r1);
	 
		ctx.close();
	}
	
	public void testDeleteFilm() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		FilmService serv = ctx.getBean(FilmService.class);
		
		serv.delete(serv.findById(1));
		
		ctx.close();
	}
	

	
	

}
