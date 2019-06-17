package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.Adherent;
import metier.Adresse;
import metier.Article;
import metier.Civilite;
import service.AdherentService;
import service.AdresseService;
import service.ArticleService;

public class TestSiham {

	public static void main(String[] args) {

		// testInsertAdherent();
		// testDeleteAdherent();
		// testUpdateAdherent();
		// testAddArticle();
		// testAddAdresse();
		//testFindByNoArticle();
		//testFindByPrenom();
		//testFindByNom();
	}

	static void testInsertAdherent() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		Adherent adherent = new Adherent();
		adherentService.insert(adherent);
		ctx.close();

	}

	static void testDeleteAdherent() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		Adherent adherent = adherentService.findByNoAdherent(2);
		adherentService.delete(adherent);
		ctx.close();
	}

	static void testUpdateAdherent() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		Adherent adherent = adherentService.findByNoAdherent(1);
		Adresse adresse = new Adresse();
		adherent.setAdresse(adresse);
		ctx.close();
	}

	static void testAddArticle() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		AdherentService adherentService = ctx.getBean(AdherentService.class);
		ArticleService articleService = ctx.getBean(ArticleService.class);
		Adherent adherent = adherentService.findByNoAdherent(1);
		Article article = articleService.findByNoArticle(2);
		adherentService.addArticle(adherent, article);
		ctx.close();
	}

	static void testAddAdresse() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		AdresseService adresseService = ctx.getBean(AdresseService.class);
		
		Adherent adherent = adherentService.findByNoAdherent(1);
		Adresse adresse = new Adresse();
		adherentService.addAdresse(adherent, adresse);
		ctx.close();

	}
	
	static void testFindByNoAdherent(){
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		
		adherentService.findByNoAdherent(12);
		ctx.close();
	}

	static void testFindByPrenom() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		
		adherentService.findByPrenom("prenom");
		ctx.close();
	}
	
	static void testFindByNom() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		AdherentService adherentService = ctx.getBean(AdherentService.class);
		
		adherentService.findByNom("nom");
		ctx.close();
	
}
}
	
	

