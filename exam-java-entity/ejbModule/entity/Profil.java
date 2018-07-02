package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profil")
public class Profil {
	
	private int id;
	private String libelle;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
