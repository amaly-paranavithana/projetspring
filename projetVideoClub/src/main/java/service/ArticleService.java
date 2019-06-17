package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metier.*;
import repository.*;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	

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


}
