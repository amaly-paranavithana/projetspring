package metier;

import javax.persistence.*;

@Entity
@DiscriminatorValue("dvd")
public class Dvd extends Article {
	private Boolean bonus;

	// Constructeur
	public Dvd() {
	}

	// Getters & Setters
	public Boolean getBonus() {
		return bonus;
	}

	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}
}
