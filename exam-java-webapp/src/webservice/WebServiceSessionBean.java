package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2018-07-02T14:47:27.616+02:00
 * Generated source version: 3.1.12
 * 
 */
@WebService(targetNamespace = "http://webservice/", name = "WebServiceSessionBean")
@XmlSeeAlso({ObjectFactory.class})
public interface WebServiceSessionBean {

    @WebMethod(action = "connexion")
    @RequestWrapper(localName = "connexion", targetNamespace = "http://webservice/", className = "webservice.Connexion")
    @ResponseWrapper(localName = "connexionResponse", targetNamespace = "http://webservice/", className = "webservice.ConnexionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean connexion(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "mdp", targetNamespace = "")
        java.lang.String mdp
    );

    @WebMethod(action = "findUtilisateurByLogin")
    @RequestWrapper(localName = "findUtilisateurByLogin", targetNamespace = "http://webservice/", className = "webservice.FindUtilisateurByLogin")
    @ResponseWrapper(localName = "findUtilisateurByLoginResponse", targetNamespace = "http://webservice/", className = "webservice.FindUtilisateurByLoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public webservice.Utilisateur findUtilisateurByLogin(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    );

    @WebMethod(action = "ajoutCommande")
    @RequestWrapper(localName = "ajoutCommande", targetNamespace = "http://webservice/", className = "webservice.AjoutCommande")
    @ResponseWrapper(localName = "ajoutCommandeResponse", targetNamespace = "http://webservice/", className = "webservice.AjoutCommandeResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String ajoutCommande(
        @WebParam(name = "date", targetNamespace = "")
        webservice.Timestamp date,
        @WebParam(name = "produit", targetNamespace = "")
        java.lang.String produit,
        @WebParam(name = "quantite", targetNamespace = "")
        int quantite,
        @WebParam(name = "prix", targetNamespace = "")
        float prix,
        @WebParam(name = "idUtilisateur", targetNamespace = "")
        int idUtilisateur,
        @WebParam(name = "idFournisseur", targetNamespace = "")
        int idFournisseur
    );
}