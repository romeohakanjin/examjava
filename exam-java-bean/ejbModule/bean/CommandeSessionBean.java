package bean;

import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import entity.Commande;
import entity.Livraison;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class CommandeSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction entityTransaction;
	private EntityManager entityManager;

	/**
	 * Ajouter une commande
	 * 
	 * @param commande
	 */
	public boolean addCommande(Commande commande) {
		boolean ajoutOk = false;

		try {
			openTransaction();
			commande.setDate(Calendar.getInstance().getTime());
			entityManager.persist(commande);
			entityTransaction.commit();
			closeTransaction();
			ajoutOk = true;
		} catch (Exception exception) {
			ajoutOk = false;
		}

		return ajoutOk;
	}

	/**
	 * Récupère la liste des commandes livrées et non payées pour le comptable
	 * 
	 * @return
	 */
	public List<Commande> findAllForComptable() {
		openTransaction();
		List<Commande> commandesList = null;
		String queryString = "FROM Commande c WHERE c.id IN (SELECT ac.idCommande FROM AccuseReception ac WHERE ac.idCommande = c.id)";
		Query query = entityManager.createQuery(queryString);
		if (query.getResultList().size() != 0) {
			commandesList = (List<Commande>) query.getResultList();
		}
		closeTransaction();
		return commandesList;
	}

	/**
	 * Récupère la liste des commandes non livrées pour le responsable des stocks
	 * 
	 * @return
	 */
	public List<Commande> findAllForResponsableStock() {
		openTransaction();
		List<Commande> commandesList = null;
		String queryString = "FROM Commande as c WHERE c.id IN (SELECT l.idCommande FROM Livraison l WHERE l.idCommande = c.id AND l.idEtatLivraison = 1)";
		Query query = entityManager.createQuery(queryString);
		if (query.getResultList().size() != 0) {
			commandesList = (List<Commande>) query.getResultList();
		}
		closeTransaction();
		return commandesList;
	}

	/**
	 * Récupère la liste de toutes les commandes
	 * 
	 * @return
	 */
	public List<Commande> findAll() {
		openTransaction();
		List<Commande> commandeList = null;
		String queryString = "FROM Commande";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			commandeList = (List<Commande>) query.getResultList();
		}

		closeTransaction();
		return commandeList;
	}

	/**
	 * Récupère une commande grâce à son id
	 * 
	 * @param id
	 * @return
	 */
	public Commande findById(int id) {
		openTransaction();

		Commande commande = entityManager.find(Commande.class, id);

		closeTransaction();
		return commande;
	}
	
	/**
	 * Vérifie si une commande existe avec son id
	 * @param id
	 * @return
	 */
	public boolean existeCommandeById(int id) {
		boolean existe = false;
		
		String queryString = "FROM Commande WHERE idCommande ='" + id + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			existe = true;
		}

		closeTransaction();
		
		return existe;
	}

	/**
	 * Ouvre la transaction
	 */
	private void openTransaction() {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}

	/**
	 * Ferme la transaction
	 */
	private void closeTransaction() {
		entityManager.close();
	}

}
