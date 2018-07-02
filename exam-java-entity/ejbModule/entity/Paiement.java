package entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paiement")
public class Paiement {

	private int id;
	private Date date;
	private Float prix;
	private int idCommande;
	private int idFacture;
	
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
	
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public int getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	
}
