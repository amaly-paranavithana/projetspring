package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import metier_martial.*;


public interface AdherentRepository extends JpaRepository<Adherent, Integer> {
	public Optional<Adherent> findByNoAdherent(Integer noAdherent);
	public List<Adherent> findByPrenom(String prenom);
	public List<Adherent> findByNom(String nom);
	
	@Query("select s from Adherent s where s.titre=:titre")
	public List<Adherent> findByTitre(@Param("titre")String titre);


}