
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AjoutCommande_QNAME = new QName("http://webservice/", "ajoutCommande");
    private final static QName _AjoutCommandeResponse_QNAME = new QName("http://webservice/", "ajoutCommandeResponse");
    private final static QName _Connexion_QNAME = new QName("http://webservice/", "connexion");
    private final static QName _ConnexionResponse_QNAME = new QName("http://webservice/", "connexionResponse");
    private final static QName _FindUtilisateurByLogin_QNAME = new QName("http://webservice/", "findUtilisateurByLogin");
    private final static QName _FindUtilisateurByLoginResponse_QNAME = new QName("http://webservice/", "findUtilisateurByLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AjoutCommande }
     * 
     */
    public AjoutCommande createAjoutCommande() {
        return new AjoutCommande();
    }

    /**
     * Create an instance of {@link AjoutCommandeResponse }
     * 
     */
    public AjoutCommandeResponse createAjoutCommandeResponse() {
        return new AjoutCommandeResponse();
    }

    /**
     * Create an instance of {@link Connexion }
     * 
     */
    public Connexion createConnexion() {
        return new Connexion();
    }

    /**
     * Create an instance of {@link ConnexionResponse }
     * 
     */
    public ConnexionResponse createConnexionResponse() {
        return new ConnexionResponse();
    }

    /**
     * Create an instance of {@link FindUtilisateurByLogin }
     * 
     */
    public FindUtilisateurByLogin createFindUtilisateurByLogin() {
        return new FindUtilisateurByLogin();
    }

    /**
     * Create an instance of {@link FindUtilisateurByLoginResponse }
     * 
     */
    public FindUtilisateurByLoginResponse createFindUtilisateurByLoginResponse() {
        return new FindUtilisateurByLoginResponse();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutCommande")
    public JAXBElement<AjoutCommande> createAjoutCommande(AjoutCommande value) {
        return new JAXBElement<AjoutCommande>(_AjoutCommande_QNAME, AjoutCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjoutCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "ajoutCommandeResponse")
    public JAXBElement<AjoutCommandeResponse> createAjoutCommandeResponse(AjoutCommandeResponse value) {
        return new JAXBElement<AjoutCommandeResponse>(_AjoutCommandeResponse_QNAME, AjoutCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connexion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "connexion")
    public JAXBElement<Connexion> createConnexion(Connexion value) {
        return new JAXBElement<Connexion>(_Connexion_QNAME, Connexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "connexionResponse")
    public JAXBElement<ConnexionResponse> createConnexionResponse(ConnexionResponse value) {
        return new JAXBElement<ConnexionResponse>(_ConnexionResponse_QNAME, ConnexionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUtilisateurByLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findUtilisateurByLogin")
    public JAXBElement<FindUtilisateurByLogin> createFindUtilisateurByLogin(FindUtilisateurByLogin value) {
        return new JAXBElement<FindUtilisateurByLogin>(_FindUtilisateurByLogin_QNAME, FindUtilisateurByLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUtilisateurByLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findUtilisateurByLoginResponse")
    public JAXBElement<FindUtilisateurByLoginResponse> createFindUtilisateurByLoginResponse(FindUtilisateurByLoginResponse value) {
        return new JAXBElement<FindUtilisateurByLoginResponse>(_FindUtilisateurByLoginResponse_QNAME, FindUtilisateurByLoginResponse.class, null, value);
    }

}
