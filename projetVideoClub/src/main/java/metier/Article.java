package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seqArticle", sequenceName="seq_Article", initialValue=1,allocationSize=1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ARTICLE_TYPE")
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seqArticle")
	@Column(name = "numéro_article")
	private Integer noArticle;
	@Column(name = "nombre_disque")
	private Integer nbDisques;

	@ManyToOne
	@JoinColumn(name="emprunteur")
	private Adherent emprunteur;
	
	@OneToMany(mappedBy="article")

	private List<Film> films;

	// Constructeur
	public Article() {
	}

	// Getters & Setters
	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}
	

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(Film film) {
		this.films.add(film);
	}

	// Hashcode & equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nbDisques == null) ? 0 : nbDisques.hashCode());
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
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
		Article other = (Article) obj;
		if (nbDisques == null) {
			if (other.nbDisques != null)
				return false;
		} else if (!nbDisques.equals(other.nbDisques))
			return false;
		if (noArticle == null) {
			if (other.noArticle != null)
				return false;
		} else if (!noArticle.equals(other.noArticle))
			return false;
		return true;
	}
}
