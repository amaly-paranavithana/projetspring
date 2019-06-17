package repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import metier.*;

public interface RealisateurRepository extends JpaRepository<Realisateur, Integer>{
	public Optional<Realisateur> findById(Integer id);
	public List<Realisateur> findByNom(String nom);
	public List<Realisateur> findByPrenom(String prenom);

}
