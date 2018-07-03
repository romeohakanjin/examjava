
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
    private final static QName _FindAllCommande_QNAME = new QName("http://webservice/", "findAllCommande");
    private final static QName _FindAllCommandeResponse_QNAME = new QName("http://webservice/", "findAllCommandeResponse");
    private final static QName _FindAllPaiement_QNAME = new QName("http://webservice/", "findAllPaiement");
    private final static QName _FindAllPaiementResponse_QNAME = new QName("http://webservice/", "findAllPaiementResponse");
    private final static QName _FindCommandeById_QNAME = new QName("http://webservice/", "findCommandeById");
    private final static QName _FindCommandeByIdResponse_QNAME = new QName("http://webservice/", "findCommandeByIdResponse");
    private final static QName _FindFournisseurById_QNAME = new QName("http://webservice/", "findFournisseurById");
    private final static QName _FindFournisseurByIdResponse_QNAME = new QName("http://webservice/", "findFournisseurByIdResponse");
    private final static QName _FindUtilisateurByLogin_QNAME = new QName("http://webservice/", "findUtilisateurByLogin");
    private final static QName _FindUtilisateurByLoginResponse_QNAME = new QName("http://webservice/", "findUtilisateurByLoginResponse");
    private final static QName _GetAccuseReception_QNAME = new QName("http://webservice/", "getAccuseReception");
    private final static QName _GetAccuseReceptionResponse_QNAME = new QName("http://webservice/", "getAccuseReceptionResponse");
    private final static QName _GetAccusesReceptions_QNAME = new QName("http://webservice/", "getAccusesReceptions");
    private final static QName _GetAccusesReceptionsResponse_QNAME = new QName("http://webservice/", "getAccusesReceptionsResponse");
    private final static QName _GetFacture_QNAME = new QName("http://webservice/", "getFacture");
    private final static QName _GetFactureResponse_QNAME = new QName("http://webservice/", "getFactureResponse");
    private final static QName _GetFactures_QNAME = new QName("http://webservice/", "getFactures");
    private final static QName _GetFacturesResponse_QNAME = new QName("http://webservice/", "getFacturesResponse");
    private final static QName _GetLivraison_QNAME = new QName("http://webservice/", "getLivraison");
    private final static QName _GetLivraisonResponse_QNAME = new QName("http://webservice/", "getLivraisonResponse");
    private final static QName _GetLivraisons_QNAME = new QName("http://webservice/", "getLivraisons");
    private final static QName _GetLivraisonsResponse_QNAME = new QName("http://webservice/", "getLivraisonsResponse");

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
     * Create an instance of {@link FindAllCommande }
     * 
     */
    public FindAllCommande createFindAllCommande() {
        return new FindAllCommande();
    }

    /**
     * Create an instance of {@link FindAllCommandeResponse }
     * 
     */
    public FindAllCommandeResponse createFindAllCommandeResponse() {
        return new FindAllCommandeResponse();
    }

    /**
     * Create an instance of {@link FindAllPaiement }
     * 
     */
    public FindAllPaiement createFindAllPaiement() {
        return new FindAllPaiement();
    }

    /**
     * Create an instance of {@link FindAllPaiementResponse }
     * 
     */
    public FindAllPaiementResponse createFindAllPaiementResponse() {
        return new FindAllPaiementResponse();
    }

    /**
     * Create an instance of {@link FindCommandeById }
     * 
     */
    public FindCommandeById createFindCommandeById() {
        return new FindCommandeById();
    }

    /**
     * Create an instance of {@link FindCommandeByIdResponse }
     * 
     */
    public FindCommandeByIdResponse createFindCommandeByIdResponse() {
        return new FindCommandeByIdResponse();
    }

    /**
     * Create an instance of {@link FindFournisseurById }
     * 
     */
    public FindFournisseurById createFindFournisseurById() {
        return new FindFournisseurById();
    }

    /**
     * Create an instance of {@link FindFournisseurByIdResponse }
     * 
     */
    public FindFournisseurByIdResponse createFindFournisseurByIdResponse() {
        return new FindFournisseurByIdResponse();
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
     * Create an instance of {@link GetAccuseReception }
     * 
     */
    public GetAccuseReception createGetAccuseReception() {
        return new GetAccuseReception();
    }

    /**
     * Create an instance of {@link GetAccuseReceptionResponse }
     * 
     */
    public GetAccuseReceptionResponse createGetAccuseReceptionResponse() {
        return new GetAccuseReceptionResponse();
    }

    /**
     * Create an instance of {@link GetAccusesReceptions }
     * 
     */
    public GetAccusesReceptions createGetAccusesReceptions() {
        return new GetAccusesReceptions();
    }

    /**
     * Create an instance of {@link GetAccusesReceptionsResponse }
     * 
     */
    public GetAccusesReceptionsResponse createGetAccusesReceptionsResponse() {
        return new GetAccusesReceptionsResponse();
    }

    /**
     * Create an instance of {@link GetFacture }
     * 
     */
    public GetFacture createGetFacture() {
        return new GetFacture();
    }

    /**
     * Create an instance of {@link GetFactureResponse }
     * 
     */
    public GetFactureResponse createGetFactureResponse() {
        return new GetFactureResponse();
    }

    /**
     * Create an instance of {@link GetFactures }
     * 
     */
    public GetFactures createGetFactures() {
        return new GetFactures();
    }

    /**
     * Create an instance of {@link GetFacturesResponse }
     * 
     */
    public GetFacturesResponse createGetFacturesResponse() {
        return new GetFacturesResponse();
    }

    /**
     * Create an instance of {@link GetLivraison }
     * 
     */
    public GetLivraison createGetLivraison() {
        return new GetLivraison();
    }

    /**
     * Create an instance of {@link GetLivraisonResponse }
     * 
     */
    public GetLivraisonResponse createGetLivraisonResponse() {
        return new GetLivraisonResponse();
    }

    /**
     * Create an instance of {@link GetLivraisons }
     * 
     */
    public GetLivraisons createGetLivraisons() {
        return new GetLivraisons();
    }

    /**
     * Create an instance of {@link GetLivraisonsResponse }
     * 
     */
    public GetLivraisonsResponse createGetLivraisonsResponse() {
        return new GetLivraisonsResponse();
    }

    /**
     * Create an instance of {@link AccuseReception }
     * 
     */
    public AccuseReception createAccuseReception() {
        return new AccuseReception();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link Commande }
     * 
     */
    public Commande createCommande() {
        return new Commande();
    }

    /**
     * Create an instance of {@link Facture }
     * 
     */
    public Facture createFacture() {
        return new Facture();
    }

    /**
     * Create an instance of {@link Livraison }
     * 
     */
    public Livraison createLivraison() {
        return new Livraison();
    }

    /**
     * Create an instance of {@link Paiement }
     * 
     */
    public Paiement createPaiement() {
        return new Paiement();
    }

    /**
     * Create an instance of {@link Fournisseur }
     * 
     */
    public Fournisseur createFournisseur() {
        return new Fournisseur();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllCommande")
    public JAXBElement<FindAllCommande> createFindAllCommande(FindAllCommande value) {
        return new JAXBElement<FindAllCommande>(_FindAllCommande_QNAME, FindAllCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllCommandeResponse")
    public JAXBElement<FindAllCommandeResponse> createFindAllCommandeResponse(FindAllCommandeResponse value) {
        return new JAXBElement<FindAllCommandeResponse>(_FindAllCommandeResponse_QNAME, FindAllCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllPaiement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllPaiement")
    public JAXBElement<FindAllPaiement> createFindAllPaiement(FindAllPaiement value) {
        return new JAXBElement<FindAllPaiement>(_FindAllPaiement_QNAME, FindAllPaiement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllPaiementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findAllPaiementResponse")
    public JAXBElement<FindAllPaiementResponse> createFindAllPaiementResponse(FindAllPaiementResponse value) {
        return new JAXBElement<FindAllPaiementResponse>(_FindAllPaiementResponse_QNAME, FindAllPaiementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCommandeById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findCommandeById")
    public JAXBElement<FindCommandeById> createFindCommandeById(FindCommandeById value) {
        return new JAXBElement<FindCommandeById>(_FindCommandeById_QNAME, FindCommandeById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCommandeByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findCommandeByIdResponse")
    public JAXBElement<FindCommandeByIdResponse> createFindCommandeByIdResponse(FindCommandeByIdResponse value) {
        return new JAXBElement<FindCommandeByIdResponse>(_FindCommandeByIdResponse_QNAME, FindCommandeByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFournisseurById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findFournisseurById")
    public JAXBElement<FindFournisseurById> createFindFournisseurById(FindFournisseurById value) {
        return new JAXBElement<FindFournisseurById>(_FindFournisseurById_QNAME, FindFournisseurById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFournisseurByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "findFournisseurByIdResponse")
    public JAXBElement<FindFournisseurByIdResponse> createFindFournisseurByIdResponse(FindFournisseurByIdResponse value) {
        return new JAXBElement<FindFournisseurByIdResponse>(_FindFournisseurByIdResponse_QNAME, FindFournisseurByIdResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccuseReception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccuseReception")
    public JAXBElement<GetAccuseReception> createGetAccuseReception(GetAccuseReception value) {
        return new JAXBElement<GetAccuseReception>(_GetAccuseReception_QNAME, GetAccuseReception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccuseReceptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccuseReceptionResponse")
    public JAXBElement<GetAccuseReceptionResponse> createGetAccuseReceptionResponse(GetAccuseReceptionResponse value) {
        return new JAXBElement<GetAccuseReceptionResponse>(_GetAccuseReceptionResponse_QNAME, GetAccuseReceptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccusesReceptions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccusesReceptions")
    public JAXBElement<GetAccusesReceptions> createGetAccusesReceptions(GetAccusesReceptions value) {
        return new JAXBElement<GetAccusesReceptions>(_GetAccusesReceptions_QNAME, GetAccusesReceptions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccusesReceptionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAccusesReceptionsResponse")
    public JAXBElement<GetAccusesReceptionsResponse> createGetAccusesReceptionsResponse(GetAccusesReceptionsResponse value) {
        return new JAXBElement<GetAccusesReceptionsResponse>(_GetAccusesReceptionsResponse_QNAME, GetAccusesReceptionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFacture")
    public JAXBElement<GetFacture> createGetFacture(GetFacture value) {
        return new JAXBElement<GetFacture>(_GetFacture_QNAME, GetFacture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFactureResponse")
    public JAXBElement<GetFactureResponse> createGetFactureResponse(GetFactureResponse value) {
        return new JAXBElement<GetFactureResponse>(_GetFactureResponse_QNAME, GetFactureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFactures")
    public JAXBElement<GetFactures> createGetFactures(GetFactures value) {
        return new JAXBElement<GetFactures>(_GetFactures_QNAME, GetFactures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getFacturesResponse")
    public JAXBElement<GetFacturesResponse> createGetFacturesResponse(GetFacturesResponse value) {
        return new JAXBElement<GetFacturesResponse>(_GetFacturesResponse_QNAME, GetFacturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraison }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraison")
    public JAXBElement<GetLivraison> createGetLivraison(GetLivraison value) {
        return new JAXBElement<GetLivraison>(_GetLivraison_QNAME, GetLivraison.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraisonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraisonResponse")
    public JAXBElement<GetLivraisonResponse> createGetLivraisonResponse(GetLivraisonResponse value) {
        return new JAXBElement<GetLivraisonResponse>(_GetLivraisonResponse_QNAME, GetLivraisonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraisons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraisons")
    public JAXBElement<GetLivraisons> createGetLivraisons(GetLivraisons value) {
        return new JAXBElement<GetLivraisons>(_GetLivraisons_QNAME, GetLivraisons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivraisonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getLivraisonsResponse")
    public JAXBElement<GetLivraisonsResponse> createGetLivraisonsResponse(GetLivraisonsResponse value) {
        return new JAXBElement<GetLivraisonsResponse>(_GetLivraisonsResponse_QNAME, GetLivraisonsResponse.class, null, value);
    }

}
