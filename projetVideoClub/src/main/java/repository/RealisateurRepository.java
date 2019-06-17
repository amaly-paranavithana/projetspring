package repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RealisateurRepository extends JpaRepository<Realisateur, Integer>{
	public List<Realisateur> findByNom(String nom);
	public List<Realisateur> findByPrenom(String prenom);

}
