package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metier.*;
import repository.*;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private RealisateurRepository realisateurRepository;
	
	@Autowired
	private FilmRealisateurRepository filmRealisateurRepository;
	

	public boolean insert(Film film) {
		if (film.getId() == null || film.getId() != 0) {
			return false;
		}
		filmRepository.save(film);
		return true;
	}

	public void delete(Film film) {
	Optional<Film> opt = filmRepository.findById(film.getId());
	if (opt.isPresent()) {
		filmRepository.delete(opt.get());
	}
	}
	
	public void addRealisateur(Film film, Realisateur realisateur) {
		Optional<Film> opt = filmRepository.findById(film.getId());
		if (opt.isPresent()) {
			FilmRealisateur filmRealisateur = new FilmRealisateur();

			filmRealisateur.setKey(new FilmRealisateurKey(opt.get(), realisateurRepository.findById(realisateur.getId()).get()));
			
			filmRealisateurRepository.save(filmRealisateur);
		}
	}
}
