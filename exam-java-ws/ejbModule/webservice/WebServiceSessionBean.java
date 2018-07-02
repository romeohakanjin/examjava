package webservice;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;

import bean.UtilisateurSessionBean;
import entity.Utilisateur;

@Stateless
@LocalBean
@WebService
public class WebServiceSessionBean {
	
	@EJB
	UtilisateurSessionBean utilisateurSessionBean;
	
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
	
	@WebMethod(action = "findUtilisateurByLogin")
	public Utilisateur findUtilisateurByLogin(@WebParam(name = "login", mode = Mode.IN) String login) {
		Utilisateur utilisateur = utilisateurSessionBean.findByLogin(login);
		return utilisateur;
	}

}
