package service;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metier.*;
import repository.*;

@Service
public class AdherentService {

	@Autowired
	private AdherentRepository adherentRepository;

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired 
	private AdresseRepository adresseRepository;

	public boolean insert(Adherent adherent) {
		if (adherent.getNom() == null || adherent.getNom().isEmpty()) {
			return false;
		}
		adherentRepository.save(adherent);
		return true;
	}

	public void delete(Adherent adherent) {
		Optional<Adherent> opt = adherentRepository.findByNoAdherent(adherent.getNoAdherent());
		if (opt.isPresent()) {
			adherentRepository.delete(opt.get());
		}
	}

	public void update(Adherent adherent) {

		Optional<Adherent> opt = adherentRepository.findById(adherent.getNoAdherent());
		if (opt.isPresent()) {
			adherentRepository.save(opt.get());
		}
	}

	public void addArticle(Adherent adherent, Article article) {
		java.util.Optional<Adherent> opt = adherentRepository.findById(adherent.getNoAdherent());
		if (opt.isPresent()) {
			java.util.Optional<Article> opt1 = articleRepository.findById(article.getNoArticle());

			if (opt1.isPresent()) {
				opt.get().setArticlesEmpruntes(opt1.get());
				adherentRepository.save(opt.get());
				articleRepository.save(opt1.get());
			}
		}
	}
	
	public void addAdresse(Adherent adherent, Adresse adresse) {
		java.util.Optional<Adherent> opt = adherentRepository.findById(adherent.getNoAdherent());
		if (opt.isPresent()) {
			java.util.Optional<Adresse> opt1 = adresseRepository.findById(adresse.getId());

			if (opt1.isPresent()) {
				opt.get().setAdresse(opt1.get());
				adherentRepository.save(opt.get());
				adresseRepository.save(opt1.get());
			}
		}
	}
	
	public Adherent findByNoAdherent(Integer noAdherent){
		return adherentRepository.findByNoAdherent(noAdherent).get();
	}
	
	public List<Adherent> findByPrenom(String prenom){
		return adherentRepository.findByPrenom(prenom);
	}
	
	public void findByNom(String nom){
		adherentRepository.findByPrenom(nom);
	}
	
}
