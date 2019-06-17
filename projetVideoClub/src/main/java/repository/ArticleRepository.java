package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import metier.*;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
public Optional<Article> findByNoArticle(Integer noArticle);
public List<Article> findByNbDisques(Integer nbDisques);
@Query("select s from Article s where s.article_type=:type")
public List<Article> findByType(@Param("type")String type);
}
