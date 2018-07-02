
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ajoutCommande complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ajoutCommande"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://webservice/}timestamp" minOccurs="0"/&gt;
 *         &lt;element name="produit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantite" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="idUtilisateur" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idFournisseur" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ajoutCommande", propOrder = {
    "date",
    "produit",
    "quantite",
    "prix",
    "idUtilisateur",
    "idFournisseur"
})
public class AjoutCommande {

    protected Timestamp date;
    protected String produit;
    protected int quantite;
    protected float prix;
    protected int idUtilisateur;
    protected int idFournisseur;

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setDate(Timestamp value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété produit.
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
     * Définit la valeur de la propriété produit.
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
     * Obtient la valeur de la propriété quantite.
     * 
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Définit la valeur de la propriété quantite.
     * 
     */
    public void setQuantite(int value) {
        this.quantite = value;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     */
    public void setPrix(float value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propriété idUtilisateur.
     * 
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * Définit la valeur de la propriété idUtilisateur.
     * 
     */
    public void setIdUtilisateur(int value) {
        this.idUtilisateur = value;
    }

    /**
     * Obtient la valeur de la propriété idFournisseur.
     * 
     */
    public int getIdFournisseur() {
        return idFournisseur;
    }

    /**
     * Définit la valeur de la propriété idFournisseur.
     * 
     */
    public void setIdFournisseur(int value) {
        this.idFournisseur = value;
    }

}
