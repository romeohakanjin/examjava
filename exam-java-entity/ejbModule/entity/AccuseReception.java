package entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accuserReception")
public class AccuseReception {

	private int id;
	private Date date;
	private int idCommande;
	private int idLivraison;
	
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
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public int getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}
	
}
