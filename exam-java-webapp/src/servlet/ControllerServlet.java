package servlet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import webservice.Utilisateur;
import webservice.WebServiceSessionBean;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int RESPONSABLE_ACHAT_PROFIL_ID = 1;
	private static final int RESPONSABLE_STOCK_PROFIL_ID = 2;
	private static final int COMPTABLE_PROFIL_ID = 3;
	private static final String HOME_PAGE = "Home";
	private static final String CONNEXION_PAGE = "Connexion";
	private static final String CONNEXION_ACTION = "connexion";
	private static final String DECONNEXION_ACTION = "deconnexion";
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private String action;
	private String login;
	private String mdp;

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
			default:
				break;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

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
				Utilisateur utilisateur = webService.findUtilisateurByLogin("fdupont");
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
