package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import metier.*;
import metier_martial.*;

public interface FilmRealisateurRepository extends JpaRepository<FilmRealisateur, Integer>{

}
