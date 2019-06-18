package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import metier.*;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	public Optional<Article> findById(Integer id);

	public List<Article> findByNbDisques(Integer nbDisques);
	// @Query query = em.createNativeQuery("SELECT * FROM Sorciers where
	// SORCIER_TYPE='eleve'", Sorcier.class);
	// List<Sorcier> liste = query.getResultList();

	@Query(value = "SELECT * FROM ARTICLES a WHERE a.article_type = 'dvd'", nativeQuery = true)
	public List<Article> findByTypeDvd();
	@Query(value = "SELECT * FROM ARTICLES a WHERE a.article_type = 'bluRay'", nativeQuery = true)
	public List<Article> findByTypeBluRay();
}
