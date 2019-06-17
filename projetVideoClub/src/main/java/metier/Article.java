package metier;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ARTICLE_TYPE")
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numéro_article")
	private Integer noArticle;
	@Column(name = "nombre_disque")
	private Integer nbDisques;

	@ManyToOne
	@JoinColumn
	private List<Adherent> emprunteur;

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

	public List<Adherent> getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(List<Adherent> emprunteur) {
		this.emprunteur = emprunteur;
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
