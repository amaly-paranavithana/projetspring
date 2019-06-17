package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.query.Param;

import metier.*;
import service.*;

public class TestHelene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testArticleFind();
	}

	public static void testArticleFind() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		
		System.out.println("Trouver un article par son num�ro : ");
		System.out.println(serv.findByNoArticle(1));

		System.out.println("Trouver un article par son nombre de disques: ");
		System.out.println(serv.findByNbDisques(1));

		System.out.println("Trouver un article par son type");

		System.out.println(serv.findByType("dvd"));
		System.out.println(serv.findByType("bluray"));

		ctx.close();

	}

	public static void testArticleInsert() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		// insert
		Article article = new Article();
		article.setNbDisques(3);
		
		//affiche true ou false
		System.out.println(serv.insert(article));
		
		// delete
		serv.delete(article);
		// update
		// addFilm
		ctx.close();
	}
	
	public static void testArticleDelete() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);

		// delete
		serv.delete(serv.findByNoArticle(6));
		
		ctx.close();
	}
	
	public static void testArticleUpdate() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		Article article=serv.findByNoArticle(6);
		
		article.setNbDisques(2);;
		// update
		
		ctx.close();
	}
	
	public static void testArticleAddFilm() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		FilmService serv1 = ctx.getBean(FilmService.class);
		Article article=serv.findByNoArticle(6);
		Film film=serv1.findById(1);
		article.setFilms(film);
		// update
		serv.addFilm(article,film);
		
		ctx.close();
	}
}
