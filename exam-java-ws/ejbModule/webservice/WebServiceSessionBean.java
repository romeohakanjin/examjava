package webservice;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;

import bean.AccuseReceptionSessionBean;
import bean.CommandeSessionBean;
import bean.FactureSessionBean;
import bean.FournisseurSessionBean;
import bean.LivraisonSessionBean;
import bean.PaiementSessionBean;
import bean.UtilisateurSessionBean;
import entity.AccuseReception;
import entity.Commande;
import entity.Facture;
import entity.Fournisseur;
import entity.Livraison;
import entity.Paiement;
import entity.Utilisateur;

@Stateless
@LocalBean
@WebService
public class WebServiceSessionBean {

	@EJB
	UtilisateurSessionBean utilisateurSessionBean;

	@EJB
	FactureSessionBean factureSessionBean;

	@EJB
	LivraisonSessionBean livraisonSessionBean;

	@EJB
	AccuseReceptionSessionBean accuseReceptionSessionBean;

	@EJB
	CommandeSessionBean commandeSessionBean;

	@EJB
	FournisseurSessionBean fournisseurSessionBean;

	@EJB
	PaiementSessionBean paiementSessionBean;

	// === Authentification === //
	@WebMethod(action = "connexion")
	public boolean connexion(@WebParam(name = "login", mode = Mode.IN) String login,
			@WebParam(name = "mdp", mode = Mode.IN) String mdp) {
		boolean verificationIdentifiants = utilisateurSessionBean.verificationIdentifiants(login, mdp);
		return verificationIdentifiants;
	}

	@WebMethod(action = "ajoutCommande")
	public String ajoutCommande(@WebParam(name = "date", mode = Mode.IN) Timestamp date,
			@WebParam(name = "produit", mode = Mode.IN) String produit,
			@WebParam(name = "quantite", mode = Mode.IN) int quantite,
			@WebParam(name = "prix", mode = Mode.IN) float prix,
			@WebParam(name = "idUtilisateur", mode = Mode.IN) int idUtilisateur,
			@WebParam(name = "idFournisseur", mode = Mode.IN) int idFournisseur) {
		return "ajout Commande " + produit;
	}

	// === Utilisateur === //
	@WebMethod(action = "findUtilisateurByLogin")
	public Utilisateur findUtilisateurByLogin(@WebParam(name = "login", mode = Mode.IN) String login) {
		Utilisateur utilisateur = utilisateurSessionBean.findByLogin(login);
		return utilisateur;
	}

	// === Commande === //

	@WebMethod(action = "findAllCommande")
	public List<Commande> findAllCommande() {
		List<Commande> commandesList = commandeSessionBean.findAll();
		return commandesList;
	}

	@WebMethod(action = "findCommandeById")
	public Commande findCommandeById(int id) {
		Commande commande = commandeSessionBean.findById(id);
		return commande;
	}

	// === Facture === //
	@WebMethod(action = "getFactures")
	public List<Facture> getFactures() {
		List<Facture> listeFactures = factureSessionBean.getFactures();
		return listeFactures;
	}

	@WebMethod(action = "facture")
	public Facture getFacture(@WebParam(name = "idFacture", mode = Mode.IN) int idFacture) {
		Facture facture = factureSessionBean.findById(idFacture);
		return facture;
	}

	// === Livraison === //
	@WebMethod(action = "getLivraisons")
	public List<Livraison> getLivraisons() {
		List<Livraison> listeLivraisons = livraisonSessionBean.getLivraisons();
		return listeLivraisons;
	}

	@WebMethod(action = "livraison")
	public Livraison getLivraison(@WebParam(name = "idLivraison", mode = Mode.IN) int idLivraison) {
		Livraison livraison = livraisonSessionBean.findById(idLivraison);
		return livraison;
	}

	// === Accusé réception === //
	@WebMethod(action = "getAccusesReceptions")
	public List<AccuseReception> getAccusesReceptions() {
		List<AccuseReception> listeAccusesReceptions = accuseReceptionSessionBean.getAccusesReceptions();
		return listeAccusesReceptions;
	}

	@WebMethod(action = "accuseReception")
	public AccuseReception getAccuseReception(
			@WebParam(name = "idAccuseReception", mode = Mode.IN) int idAccuseReception) {
		AccuseReception accuseReception = accuseReceptionSessionBean.findById(idAccuseReception);
		return accuseReception;
	}

	// === Fournisseur === //
	@WebMethod(action = "findFournisseurById")
	public Fournisseur findFournisseurById(@WebParam(name = "id", mode = Mode.IN) int id) {
		Fournisseur fournisseur = fournisseurSessionBean.findById(id);
		return fournisseur;
	}

	// === Paiement === //

	@WebMethod(action = "findAllPaiement")
	public List<Paiement> findAllPaiement() {
		List<Paiement> paiementsList = paiementSessionBean.findAll();
		return paiementsList;
	}

}
