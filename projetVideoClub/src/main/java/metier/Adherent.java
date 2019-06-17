package metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import metier.Adresse;
import metier.Article;

@Entity
public class Adherent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noAdherent;
	private Civilite titre;
	private String prenom;
	private String nom;
	
	
	@OneToMany(mappedBy="emprunteur")
	@JoinColumn
	private List<Article> articlesEmpruntes;

	
	@OneToOne(mappedBy = "id_adherent")
	private Adresse adresse;
	
	public Integer getNoAdherent() {
		return noAdherent;
	}

	public void setNoAdherent(Integer noAdherent) {
		this.noAdherent = noAdherent;
	}

	
	public Adherent () {
		
	}

	public Civilite getTitre() {
		return titre;
	}

	public void setTitre(Civilite titre) {
		this.titre = titre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Article> getArticlesEmpruntes() {
		return articlesEmpruntes;
	}

	public void setArticlesEmpruntes(Article articleEmprunte) {
		this.articlesEmpruntes.add(articleEmprunte);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noAdherent == null) ? 0 : noAdherent.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adherent other = (Adherent) obj;
		if (noAdherent == null) {
			if (other.noAdherent != null)
				return false;
		} else if (!noAdherent.equals(other.noAdherent))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (titre != other.titre)
			return false;
		return true;
	}

	
	
	
	
}
