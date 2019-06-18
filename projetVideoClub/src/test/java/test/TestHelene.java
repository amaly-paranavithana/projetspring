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
		
		System.out.println("Trouver un article par son numéro : ");
		System.out.println(serv.findById(2));

		System.out.println("Trouver un article par son nombre de disques: ");
		System.out.println(serv.findByNbDisques(3));

		System.out.println("Trouver un article par son type");

		System.out.println(serv.findByTypeDvd());
		System.out.println(serv.findByTypeBluRay());

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
		serv.delete(serv.findById(6));
		
		ctx.close();
	}
	
	public static void testArticleUpdate() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		Article article=serv.findById(6);
		
		article.setNbDisques(2);;
		// update
		
		ctx.close();
	}
	
	public static void testArticleAddFilm() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		FilmService serv1 = ctx.getBean(FilmService.class);
		Article article=serv.findById(6);
		Film film=serv1.findById(1);
		article.setFilms(film);
		// update
		serv.addFilm(article,film);
		
		ctx.close();
	}
	public static void testAdherentAddArticle() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ArticleService serv = ctx.getBean(ArticleService.class);
		AdherentService serv1 = ctx.getBean(AdherentService.class);
		Article article=serv.findById(6);
		Adherent adherent=serv1.findByNoAdherent(1);
		adherent.setArticlesEmpruntes(article);
		// update
		serv1.addArticle(adherent, article);
		
		ctx.close();
	}
	
}
