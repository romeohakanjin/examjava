package bean;

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

	private EntityManager entityManager;

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
	 * @param id
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
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}

	/**
	 * Ferme la transaction
	 */
	private void closeTransaction() {
		entityManager.close();
	}
}