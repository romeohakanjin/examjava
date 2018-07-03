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
	public void ajoutCommande(@WebParam(name = "commande", mode = Mode.IN) Commande commande) {
		commandeSessionBean.addCommande(commande);
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
	
	@WebMethod(action = "findAllcommandeForComptable")
	public List<Commande> findAllcommandeForComptable() {
		List<Commande> commandesList = commandeSessionBean.findAllForComptable();
		return commandesList;
	} 
	
	@WebMethod(action = "findAllcommandeForResponsableStock")
	public List<Commande> findAllcommandeForResponsableStock() {
		List<Commande> commandesList = commandeSessionBean.findAllForResponsableStock();
		return commandesList;
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
	
	@WebMethod(action = "ajoutFacture")
	public boolean ajoutFacture(@WebParam(name = "idCommande", mode = Mode.IN) int idCommande) {
		boolean isAdded = factureSessionBean.ajoutFacture(idCommande);
		return isAdded;
	}
	
	@WebMethod(action = "findFactureByIdCommande")
	public Facture findFactureByIdCommande(@WebParam(name = "idCommande", mode = Mode.IN) int idCommande) {
		Facture facture = factureSessionBean.findByIdCommande(idCommande);
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
	
	@WebMethod(action = "findAccuseReceptionByIdCommande")
	public AccuseReception findAccuseReceptionByIdCommande(@WebParam(name = "idCommande", mode = Mode.IN) int idCommande) {
		AccuseReception accuseReception = accuseReceptionSessionBean.findAccuseReceptionByIdCommande(idCommande);
		return accuseReception;
	}
	
	// === Fournisseur === //
	@WebMethod(action = "findFournisseurById")
	public Fournisseur findFournisseurById(@WebParam(name = "id", mode = Mode.IN) int id) {
		Fournisseur fournisseur = fournisseurSessionBean.findById(id);
		return fournisseur;
	}
	
	@WebMethod(action = "getFournisseurs")
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> listeFournisseurs = fournisseurSessionBean.getFournisseurs();
		return listeFournisseurs;
	}

	// === Paiement === //

	@WebMethod(action = "findAllPaiement")
	public List<Paiement> findAllPaiement() {
		List<Paiement> paiementsList = paiementSessionBean.findAll();
		return paiementsList;
	}

}
