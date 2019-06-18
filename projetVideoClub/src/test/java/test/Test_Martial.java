package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.Adherent;
import metier.Adresse;
import metier.Article;
import metier.BluRay;
import metier.Civilite;
import metier.Dvd;
import metier.Film;
import metier.Realisateur;
import service.AdherentService;
import service.AdresseService;
import service.ArticleService;
import service.FilmService;

public class Test_Martial {

	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
	
		AdherentService adherentService = ctx.getBean(AdherentService.class);
		AdresseService adresseService = ctx.getBean(AdresseService.class);
		FilmService filmService = ctx.getBean(FilmService.class);
		ArticleService articleService = ctx.getBean(ArticleService.class);
		
		
		Adresse adr1 = new Adresse();
		adr1.setNumero(1);
		adr1.setRue("rue de la paix");
		adr1.setVille("Paris");
		adr1.setCp("75000");
		
		Adresse adr2 = new Adresse();
		adr2.setNumero(6);
		adr2.setRue("rue Rougemont");
		adr2.setVille("Paris");
		adr2.setCp("75009");
		
		Film f1 = new Film();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		f1.setTitre("Jurassic Park");
		f1.setDate(sdf.parse("01/02/2010"));
		
		Film f2 = new Film();
		f2.setTitre("Star Wars");
		f2.setDate(sdf.parse("25/10/1995"));
		
		Realisateur real1 = new Realisateur();
		real1.setNom("Spielberg");
		real1.setPrenom("Steven");
		
		Realisateur real2 = new Realisateur();
		real2.setNom("Lucas");
		real2.setPrenom("Georges");
		
		Adherent ad1 = new Adherent();
		ad1.setTitre(Civilite.Monsieur);
		ad1.setNom("Le Blanc");
		ad1.setPrenom("Gandalf");
		//ad1.setAdresse(adr1);
		
		Adherent ad2 = new Adherent();
		ad2.setTitre(Civilite.Madame);
		ad2.setNom("Neige");
		ad2.setPrenom("Blanche");
		//ad2.setAdresse(adr2);
		
		BluRay blu1 = new BluRay();
		blu1.setNbDisques(6);
		blu1.setTroisD(true);
		
		Dvd dvd1 = new Dvd();
		dvd1.setNbDisques(3);
		dvd1.setBonus(true);
		
		adherentService.insert(ad1);
		adherentService.insert(ad2);
		
		adr1.setId(1);
		adr2.setId(2);
		adresseService.insert(adr1);
		adresseService.insert(adr2);
		
		f1.setId(1);
		f2.setId(2);
		filmService.insert(f1);
		filmService.insert(f2);
		
		blu1.setId(1);
		dvd1.setId(2);
		articleService.insert(blu1);
		articleService.insert(dvd1);
		
		ctx.close();
		
	}

}
