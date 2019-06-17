package metier_martial;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Adherent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noAdherent;
	private Civilite titre;
	private String prenom;
	private String nom;

	
	@OneToOne(mappedBy = "key.adherent")
	private Adresse adresse;
	
	@OneToMany
	@JoinColumn
	private List<Article> articlesEmpruntes;
	
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

	public Integer getNumadhe() {
		return numadhe;
	}

	public void setNumadhe(Integer numadhe) {
		this.numadhe = numadhe;
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

	public void setArticlesEmpruntes(List<Article> articlesEmpruntes) {
		this.articlesEmpruntes = articlesEmpruntes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numadhe == null) ? 0 : numadhe.hashCode());
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
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numadhe == null) {
			if (other.numadhe != null)
				return false;
		} else if (!numadhe.equals(other.numadhe))
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
