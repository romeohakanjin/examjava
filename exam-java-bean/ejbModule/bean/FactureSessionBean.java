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

import entity.Facture;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	/**
	 * Récupère une facture grâce à son id
	 * 
	 * @param id
	 * @return facture
	 */
	public Facture findById(int id) {
		openTransaction();
		String queryString = "FROM Facture WHERE id ='" + id + "' ";

		Facture facture = entityManager.find(Facture.class, id);

		closeTransaction();
		return facture;
	}

	/**
	 * Récupère la liste des factures
	 * 
	 * @param id
	 * @return List<Facture>
	 */
	public List<Facture> getFactures() {
		openTransaction();
		String queryString = "FROM Facture";
		Query query = entityManager.createQuery(queryString);

		List<Facture> listeFactures = query.getResultList();

		closeTransaction();
		return listeFactures;
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