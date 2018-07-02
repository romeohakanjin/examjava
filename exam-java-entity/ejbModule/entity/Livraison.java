package entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livraison")
public class Livraison {

	private int id;
	private Date date;
	private String adresse;
	private String codePostal;
	private String ville;
	private int idCommande;
	private int idEtatLivraison;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public int getIdEtatLivraison() {
		return idEtatLivraison;
	}
	public void setIdEtatLivraison(int idEtatLivraison) {
		this.idEtatLivraison = idEtatLivraison;
	}
	
}
