
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour accuseReception complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="accuseReception"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://webservice/}date" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idCommande" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idLivraison" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accuseReception", propOrder = {
    "date",
    "id",
    "idCommande",
    "idLivraison"
})
public class AccuseReception {

    protected Date date;
    protected int id;
    protected int idCommande;
    protected int idLivraison;

    /**
     * Obtient la valeur de la propri�t� date.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDate() {
        return date;
    }

    /**
     * D�finit la valeur de la propri�t� date.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDate(Date value) {
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
     * Obtient la valeur de la propri�t� idCommande.
     * 
     */
    public int getIdCommande() {
        return idCommande;
    }

    /**
     * D�finit la valeur de la propri�t� idCommande.
     * 
     */
    public void setIdCommande(int value) {
        this.idCommande = value;
    }

    /**
     * Obtient la valeur de la propri�t� idLivraison.
     * 
     */
    public int getIdLivraison() {
        return idLivraison;
    }

    /**
     * D�finit la valeur de la propri�t� idLivraison.
     * 
     */
    public void setIdLivraison(int value) {
        this.idLivraison = value;
    }

}