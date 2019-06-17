package service;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metier.*;
import repository.*;

@Service
public class AdherentService {

	@Autowired
	private AdherentRepository adherentRepository;
	

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

}
	

