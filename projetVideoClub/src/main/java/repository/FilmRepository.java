package repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import metier.*;

public interface FilmRepository extends JpaRepository<Film, Integer> {
	public Optional<Film> findById(Integer id);
	public List<Film> findByTitre(String titre);
	public List<Film> findByDate(Date date);

}