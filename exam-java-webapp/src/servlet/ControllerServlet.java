package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import webservice.AccuseReception;
import webservice.Commande;
import webservice.Facture;
import webservice.Livraison;
import webservice.Paiement;
import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// === Profil ID === //
	private static final int RESPONSABLE_ACHAT_PROFIL_ID = 1;
	private static final int RESPONSABLE_STOCK_PROFIL_ID = 2;
	private static final int COMPTABLE_PROFIL_ID = 3;
	// === JSP === //
	private static final String HOME_PAGE = "Home";
	private static final String CONNEXION_PAGE = "Connexion";
	private static final String LISTE_FACTURES_PAGE = "ListeFactures";
	private static final String DETAILS_FACTURE_PAGE = "Facture";
	private static final String LISTE_LIVRAISONS_PAGE = "ListeLivraisons";
	private static final String DETAILS_LIVRAISON_PAGE = "Livraison";
	private static final String LISTE_ACCUSES_RECEPTIONS_PAGE = "ListeAccusesReceptions";
	private static final String DETAILS_ACCUSE_RECEPTION_PAGE = "AccuseReception";
	private static final String LISTE_COMMANDES_PAGE = "ListeCommandes";
	private static final String COMMANDE_DETAIL_PAGE = "CommandeDetail";
	private static final String LISTE_PAIEMENTS_PAGE = "ListePaiements";
	// === Action === //
	private static final String CONNEXION_ACTION = "connexion";
	private static final String DECONNEXION_ACTION = "deconnexion";
	private static final String LISTE_COMMANDES_ACTION = "listeCommandes";
	private static final String COMMANDE_DETAIL_ACTION = "commandeDetail";
	private static final String LISTE_PAIEMENTS_ACTION = "listePaiements";
	private static final String LISTE_FACTURES_ACTION = "listeFactures";
	private static final String FACTURE_ACTION = "detailsFacture";
	private static final String LISTE_LIVRAISONS_ACTION = "listeLivraisons";
	private static final String LIVRAISON_ACTION = "detailsLivraison";
	private static final String LISTE_ACCUSES_RECEPTIONS_ACTION = "listeAccusesReceptions";
	private static final String ACCUSE_RECEPTION_ACTION = "detailsAccuseReception";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private String action;
	private String login;
	private String mdp;
	private String idFacture;
	private String idLivraison;
	private String idAccuseReception;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initialize(request, response);

		try {
			URL url = new URL("http://Junzi:8080/exam-java-ws/WebServiceSessionBean?wsdl");
			QName qname = new QName("http://webservice/", "WebServiceSessionBeanService");
			Service service = Service.create(url, qname);
			WebServiceSessionBean webService = service.getPort(WebServiceSessionBean.class);

			switch (action) {
			case CONNEXION_ACTION:
				connexionActionPerformed(webService);
				break;
			case DECONNEXION_ACTION:
				deconnexionActionPerformed();
				break;
			case LISTE_FACTURES_ACTION:
				listeFacturesActionPerformed(webService);
				break;
			case FACTURE_ACTION:
				factureActionPerformed(webService);
				break;
			case LISTE_LIVRAISONS_ACTION:
				listeLivraisonsActionPerformed(webService);
				break;
			case LIVRAISON_ACTION:
				livraisonActionPerformed(webService);
				break;
			case LISTE_ACCUSES_RECEPTIONS_ACTION:
				listeAccusesReceptionsActionPerformed(webService);
				break;
			case ACCUSE_RECEPTION_ACTION:
				accuseReceptionActionPerformed(webService);
				break;
			case LISTE_COMMANDES_ACTION:
				listeCommandesActionPerformed(webService, request);
				break;
			case COMMANDE_DETAIL_ACTION:
				int idCommande = Integer.valueOf(request.getParameter("idCommande"));
				if (idCommande != 0) {
					commandeDetailActionPerformed(webService, request, idCommande);
				} else {
					setVariableToView("alert-danger", "Commande introuvable");
				}
				break;
			case LISTE_PAIEMENTS_ACTION:
				if (session.getAttribute("session-role") == "comptable") {
					listePaiementsActionPerformed(webService, request);
				} else {
					setVariableToView("alert-danger",
							"Vous n'avez pas les droits nécessaires pour accéder à cette page");
				}
			default:
				break;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Liste des factures
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeFacturesActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		List<Facture> listeFactures = webService.getFactures();
		this.request.setAttribute("listeFactures", listeFactures);
		redirectionToView(LISTE_FACTURES_PAGE);
	}

	/**
	 * Détails d'une facture
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void factureActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		try {
			int idFactureNumber = Integer.valueOf(this.idFacture);
			Facture facture = webService.getFacture(idFactureNumber);
			this.request.setAttribute("detailsFacture", facture);
			redirectionToView(DETAILS_FACTURE_PAGE);
		} catch (NumberFormatException exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Liste des livraisons
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeLivraisonsActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		List<Livraison> listeLivraisons = webService.getLivraisons();
		this.request.setAttribute("listeLivraisons", listeLivraisons);
		redirectionToView(LISTE_LIVRAISONS_PAGE);
	}

	/**
	 * Détails d'une livraison
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void livraisonActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		try {
			int idLivraisonNumber = Integer.valueOf(this.idLivraison);
			Livraison livraison = webService.getLivraison(idLivraisonNumber);
			this.request.setAttribute("detailsLivraison", livraison);
			redirectionToView(DETAILS_LIVRAISON_PAGE);
		} catch (NumberFormatException exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Liste des accusés réceptions
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeAccusesReceptionsActionPerformed(WebServiceSessionBean webService)
			throws ServletException, IOException {
		List<AccuseReception> listeAccusesReceptions = webService.getAccusesReceptions();
		this.request.setAttribute("listeAccusesReceptions", listeAccusesReceptions);
		redirectionToView(LISTE_ACCUSES_RECEPTIONS_PAGE);
	}

	/**
	 * Détails d'un accusé réception
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void accuseReceptionActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		try {
			int idAccuseReceptionNumber = Integer.valueOf(this.idAccuseReception);
			AccuseReception accuseReception = webService.getAccuseReception(idAccuseReceptionNumber);
			this.request.setAttribute("detailsAccuseReception", accuseReception);
			redirectionToView(DETAILS_ACCUSE_RECEPTION_PAGE);
		} catch (NumberFormatException exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Liste des paiements
	 * 
	 * @param webService
	 * @param request
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listePaiementsActionPerformed(WebServiceSessionBean webService, HttpServletRequest request)
			throws ServletException, IOException {
		List<Paiement> paiementsList = webService.findAllPaiement();
		request.setAttribute("listePaiements", paiementsList);
		redirectionToView(LISTE_PAIEMENTS_PAGE);
	}

	/**
	 * Détail d'une commande
	 * 
	 * @param webService
	 * @param request
	 * @throws IOException
	 * @throws ServletException
	 */
	private void commandeDetailActionPerformed(WebServiceSessionBean webService, HttpServletRequest request,
			int idCommande) throws ServletException, IOException {
		Commande commande = webService.findCommandeById(idCommande);
		String nomFournisseur = webService.findFournisseurById(commande.getIdFournisseur()).getNom();
		request.setAttribute("commande", commande);
		request.setAttribute("fournisseur", nomFournisseur);
		redirectionToView(COMMANDE_DETAIL_PAGE);
	}

	/**
	 * Liste des commandes
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listeCommandesActionPerformed(WebServiceSessionBean webService, HttpServletRequest request)
			throws ServletException, IOException {
		List<Commande> commandesList = webService.findAllCommande();
		List<String> nomFournisseursList = new ArrayList<String>();
		for (Commande commande : commandesList) {
			nomFournisseursList.add(webService.findFournisseurById(commande.getIdFournisseur()).getNom());
		}
		request.setAttribute("commandesList", commandesList);
		request.setAttribute("fournisseursList", nomFournisseursList);
		redirectionToView(LISTE_COMMANDES_PAGE);
	}

	/**
	 * Action pour l'événement de Connexion
	 * 
	 * @param webService
	 * @throws IOException
	 * @throws ServletException
	 */
	private void connexionActionPerformed(WebServiceSessionBean webService) throws ServletException, IOException {
		boolean isOkForm = true;

		if (this.login == null || "".equals(this.login)) {
			isOkForm = false;
		}

		if (this.mdp == null || "".equals(this.mdp)) {
			isOkForm = false;
		}

		if (isOkForm) {
			boolean verificationIdentifiants = webService.connexion(this.login, this.mdp);

			if (verificationIdentifiants) {
				httpSession(login, mdp);
				Utilisateur utilisateur = webService.findUtilisateurByLogin(login);
				int idProfil = utilisateur.getIdProfil();

				switch (idProfil) {
				case RESPONSABLE_ACHAT_PROFIL_ID:
					session.setAttribute("session-role", "responsableAchat");
					break;
				case RESPONSABLE_STOCK_PROFIL_ID:
					session.setAttribute("session-role", "responsableStock");
					break;
				case COMPTABLE_PROFIL_ID:
					session.setAttribute("session-role", "comptable");
					break;
				default:
					break;
				}

				redirectionToView(HOME_PAGE);
			} else {
				setVariableToView("alert-danger", "Identifiants incorrect");
				redirectionToView(CONNEXION_PAGE);
			}

		} else {
			setVariableToView("alert-danger", "Veuillez saisir tous les champs");
			redirectionToView(CONNEXION_PAGE);
		}

	}

	/**
	 * Supprime les attributs de la Session
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	private void deconnexionActionPerformed() throws ServletException, IOException {
		// delete params in http session
		session.invalidate();
		// redirection home
		redirectionToView(HOME_PAGE);
	}

	/**
	 * Initialize the values
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void initialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();

		action = request.getParameter("action");
		login = request.getParameter("login");
		mdp = request.getParameter("mdp");
		idFacture = request.getParameter("idFacture");
		idLivraison = request.getParameter("idLivraison");
		idAccuseReception = request.getParameter("idAccuseReception");

		response.setContentType("text/html");
	}

	/**
	 * Set the httpSession
	 * 
	 * @param login
	 * @param password
	 */
	protected void httpSession(String login, String password) {
		session.setAttribute("login", login);
		session.setAttribute("password", password);
	}

	/**
	 * Feed request attribute
	 * 
	 * @param variable
	 * @param message
	 */
	private void setVariableToView(String variable, String message) {
		request.setAttribute(variable, message);
	}

	/**
	 * Redirection to a view
	 * 
	 * @param String
	 *            : the view name
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redirectionToView(String view) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(view + ".jsp");
		dispatcher.include(request, response);
	}

	/**
	 * Redirection to a servlet
	 * 
	 * @param String
	 *            : the servlet name
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redirectionToServlet(String sevlet) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(sevlet);
		dispatcher.include(request, response);
	}
}
