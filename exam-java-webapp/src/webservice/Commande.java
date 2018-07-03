
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour commande complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="commande"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idFournisseur" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idUtilisateur" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/&gt;
 *         &lt;element name="produit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commande", propOrder = {
    "date",
    "id",
    "idFournisseur",
    "idUtilisateur",
    "prix",
    "produit",
    "quantite"
})
public class Commande {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected int id;
    protected int idFournisseur;
    protected int idUtilisateur;
    protected Float prix;
    protected String produit;
    protected int quantite;

    /**
     * Obtient la valeur de la propri�t� date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * D�finit la valeur de la propri�t� date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� idFournisseur.
     * 
     */
    public int getIdFournisseur() {
        return idFournisseur;
    }

    /**
     * D�finit la valeur de la propri�t� idFournisseur.
     * 
     */
    public void setIdFournisseur(int value) {
        this.idFournisseur = value;
    }

    /**
     * Obtient la valeur de la propri�t� idUtilisateur.
     * 
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * D�finit la valeur de la propri�t� idUtilisateur.
     * 
     */
    public void setIdUtilisateur(int value) {
        this.idUtilisateur = value;
    }

    /**
     * Obtient la valeur de la propri�t� prix.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPrix() {
        return prix;
    }

    /**
     * D�finit la valeur de la propri�t� prix.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPrix(Float value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propri�t� produit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduit() {
        return produit;
    }

    /**
     * D�finit la valeur de la propri�t� produit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduit(String value) {
        this.produit = value;
    }

    /**
     * Obtient la valeur de la propri�t� quantite.
     * 
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * D�finit la valeur de la propri�t� quantite.
     * 
     */
    public void setQuantite(int value) {
        this.quantite = value;
    }

}
