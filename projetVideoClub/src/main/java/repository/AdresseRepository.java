package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import metier.*;


public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
	public Optional<Adresse> findById(Integer id);
	public List<Adresse> findByNumero(Integer numero);
	public List<Adresse> findByRue(String rue);
	public List<Adresse> findByVille(String ville);
	public List<Adresse> findByCp(String cp);
}