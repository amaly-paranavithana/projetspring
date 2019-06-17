package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import metier.*;
import repository.*;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository adresseRepository;

	public boolean insert(Adresse adresse) {
		if (adresse.getId() == null || adresse.getId() != 0) {
			return false;
		}
		adresseRepository.save(adresse);
		return true;
	}

	public void delete(Adresse adresse) {
		Optional<Adresse> opt = adresseRepository.findById(adresse.getId());
		if (opt.isPresent()) {
			adresseRepository.delete(opt.get());
		}
	}

	public void update(Adresse adresse) {

		Optional<Adresse> opt = adresseRepository.findById(adresse.getId());
		if (opt.isPresent()) {
			adresseRepository.save(opt.get());
		}
	}

	public Adresse findById(Integer id) {
		return adresseRepository.findById(id).get();
	}

	public List<Adresse> findByNumero(Integer numero) {
		return adresseRepository.findByNumero(numero);
	}

	public List<Adresse> findByRue(String rue) {
		return adresseRepository.findByRue(rue);
	}

	public List<Adresse> findByVille(String ville) {
		return adresseRepository.findByVille(ville);
	}

	public List<Adresse> findByCp(String cp) {
		return adresseRepository.findByCp(cp);
	}
}
