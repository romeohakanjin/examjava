package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livraison")
public class Livraison {

	private int id;
	private Date date;
	private int idCommande;
	private int idEtatLivraison;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public int getIdEtatLivraison() {
		return idEtatLivraison;
	}

	public void setIdEtatLivraison(int idEtatLivraison) {
		this.idEtatLivraison = idEtatLivraison;
	}

}
