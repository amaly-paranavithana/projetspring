package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import metier.*;
import repository.*;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private FilmRepository filmRepository;

	public boolean insert(Article article) {
		if (article.getNoArticle() == null || article.getNoArticle() != 0) {
			return false;
		}
		articleRepository.save(article);
		return true;
	}

	public void delete(Article article) {
		Optional<Article> opt = articleRepository.findById(article.getNoArticle());
		if (opt.isPresent()) {
			articleRepository.delete(opt.get());
		}
	}

	public void update(Article article) {

		Optional<Article> opt = articleRepository.findByNoArticle(article.getNoArticle());
		if (opt.isPresent()) {
			articleRepository.save(opt.get());

		}
	}

	public void addFilm(Article article, Film film) {
		Optional<Article> opt = articleRepository.findByNoArticle(article.getNoArticle());
		if (opt.isPresent()) {
			Optional<Film> opt1 = filmRepository.findById(film.getId());

			if (opt1.isPresent()) {
				article.setFilms(film);
			}

			filmRepository.save(opt1.get());
			articleRepository.save(opt.get());

		}
	}

	public Article findByNoArticle(Integer noArticle) {
		return articleRepository.findByNoArticle(noArticle).get();
	}
	
	public List<Article> findByNbDisques(Integer nbDisques){
	return articleRepository.findByNbDisques(nbDisques);
}
	
	public List<Article> findByType(@Param("type")String type){
	return articleRepository.findByType(type);
	}
	
}

