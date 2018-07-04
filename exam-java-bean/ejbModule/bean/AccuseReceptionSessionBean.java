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

import entity.AccuseReception;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class AccuseReceptionSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction entityTransaction;
	private EntityManager entityManager;

	/**
	 * Ajouter un accusé réception
	 * 
	 * @param accuseReception
	 */
	public boolean ajoutAccuseReception(AccuseReception accuseReception) {
		boolean ajoutOk = false;

		try {
			openTransaction();
			accuseReception.setDate(Calendar.getInstance().getTime());
			entityManager.persist(accuseReception);
			entityTransaction.commit();
			closeTransaction();
			ajoutOk = true;
		} catch (Exception exception) {
			ajoutOk = false;
		}

		return ajoutOk;
	}

	/**
	 * Récupère l'accusé de réception pour une commande
	 * 
	 * @param idCommande
	 * @return
	 */
	public AccuseReception findAccuseReceptionByIdCommande(int idCommande) {
		openTransaction();
		AccuseReception accuseReception = null;
		String queryString = "FROM AccuseReception WHERE idCommande ='" + idCommande + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			accuseReception = (AccuseReception) query.getSingleResult();
		}

		closeTransaction();
		return accuseReception;
	}

	/**
	 * Récupère un accusé réception grâce à son id
	 * 
	 * @param id
	 * @return AccuseReception
	 */
	public AccuseReception findById(int id) {
		openTransaction();
		String queryString = "FROM AccuseReception WHERE id ='" + id + "' ";

		AccuseReception accuseReception = entityManager.find(AccuseReception.class, id);

		closeTransaction();
		return accuseReception;
	}

	/**
	 * Récupère la liste des Accusés réceptions
	 * 
	 * @return List<AccuseReception>
	 */
	public List<AccuseReception> getAccusesReceptions() {
		openTransaction();
		String queryString = "FROM AccuseReception";
		Query query = entityManager.createQuery(queryString);

		List<AccuseReception> listeAccusesReceptions = query.getResultList();

		closeTransaction();
		return listeAccusesReceptions;
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
	
	/**
	 * Vérifie la présence d'un accusé réception
	 * @param id
	 * @return true / false si l'accusé de réception existe
	 */
	public boolean existeAccuseReceptionByIdCommande(int id) {
		boolean existe = false;

		String queryString = "FROM AccuseReception WHERE idCommande ='" + id + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			existe = true;
		}

		closeTransaction();

		return existe;
	}
}
