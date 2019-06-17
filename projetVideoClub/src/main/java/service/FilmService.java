package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metier.Article;
import metier_martial.Film;
import repository.ArticleRepository;
import repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository;
	

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

}
