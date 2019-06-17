package metier;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import metier.Article;

@Entity
@SequenceGenerator(name = "seqFilm", sequenceName="seq_Film", initialValue=1,allocationSize=1)
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqFilm")
	private Integer id;
	
	private String titre;
	
	@ManyToOne
	@JoinColumn
	private Article article;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_sortie")
	private Date date;
	
	@OneToMany(mappedBy = "key.film")
	private List<FilmRealisateur> filmrealisateur; 
	
	public Film(){}
	
	

	public List<FilmRealisateur> getFilmrealisateur() {
		return filmrealisateur;
	}

	public void setFilmrealisateur(List<FilmRealisateur> filmrealisateur) {
		this.filmrealisateur = filmrealisateur;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Film other = (Film) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	
	
	
	


}
