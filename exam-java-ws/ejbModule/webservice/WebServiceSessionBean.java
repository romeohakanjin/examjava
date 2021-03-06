package webservice;

import java.util.Calendar;
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
		boolean ajoutOk = commandeSessionBean.addCommande(commande);

		if (ajoutOk) {
			Livraison livraison = new Livraison();
			livraison.setIdCommande(commande.getId());
			livraison.setIdEtatLivraison(1);
			livraison.setDate(Calendar.getInstance().getTime());
			livraisonSessionBean.ajoutLivraison(livraison);
		}

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

	@WebMethod(action = "existeCommandeById")
	public boolean existeCommandeById(int id) {
		boolean existe = commandeSessionBean.existeCommandeById(id);
		return existe;
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
		Facture facture = new Facture();
		facture.setIdCommande(idCommande);
		facture.setDate(Calendar.getInstance().getTime());
		boolean isAdded = factureSessionBean.ajoutFacture(facture);
		return isAdded;
	}

	@WebMethod(action = "findFactureByIdCommande")
	public Facture findFactureByIdCommande(@WebParam(name = "idCommande", mode = Mode.IN) int idCommande) {
		Facture facture = factureSessionBean.findByIdCommande(idCommande);
		return facture;
	}

	// === Livraison === //
	@WebMethod(action = "findLivraisonByCommandId")
	public Livraison findLivraisonByCommandId(@WebParam(name = "idCommande", mode = Mode.IN) int idCommande) {
		Livraison livraison = livraisonSessionBean.findLivraisonByCommandId(idCommande);
		return livraison;
	}

	@WebMethod(action = "existeLivraisonByCommandId")
	public boolean existeLivraisonByCommandId(int id) {
		boolean existe = livraisonSessionBean.existeLivraisonByCommandId(id);
		return existe;
	}

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
	@WebMethod(action = "ajoutAccuseReception")
	public boolean ajoutAccuseReception(
			@WebParam(name = "accuseReception", mode = Mode.IN) AccuseReception accuseReception) {
		boolean ajoutOk = accuseReceptionSessionBean.ajoutAccuseReception(accuseReception);
		return ajoutOk;
	}

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
	public AccuseReception findAccuseReceptionByIdCommande(
			@WebParam(name = "idCommande", mode = Mode.IN) int idCommande) {
		AccuseReception accuseReception = accuseReceptionSessionBean.findAccuseReceptionByIdCommande(idCommande);
		return accuseReception;
	}

	@WebMethod(action = "existeAccuseReceptionByIdCommande")
	public boolean existeAccuseReceptionByIdCommande(int id) {
		boolean existe = accuseReceptionSessionBean.existeAccuseReceptionByIdCommande(id);
		return existe;
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

	@WebMethod(action = "ajoutPaiement")
	public boolean ajoutPaiement(@WebParam(name = "idFacture", mode = Mode.IN) int idFacture) {
		Paiement paiement = new Paiement();
		paiement.setDate(Calendar.getInstance().getTime());
		paiement.setIdFacture(idFacture);
		paiement.setIdCommande(factureSessionBean.findById(idFacture).getIdCommande());
		boolean isAdded = paiementSessionBean.ajoutPaiement(paiement);
		return isAdded;
	}

}
