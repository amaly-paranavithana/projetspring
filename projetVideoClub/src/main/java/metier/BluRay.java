package metier;

import javax.persistence.*;

@Entity
@DiscriminatorValue("bluRay")
public class BluRay extends Article {
	private Boolean troisD;
	
	
	//Constructeur
	public BluRay() {
	}

	
	// Getters & Setters
	public boolean isTroisD() {
		return troisD;
	}
	public void setTroisD(boolean troisD) {
		this.troisD = troisD;
	}
}
