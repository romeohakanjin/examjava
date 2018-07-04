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

import entity.Paiement;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class PaiementSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;
	
	private EntityTransaction entityTransaction;
	
	public boolean ajoutPaiement(Paiement paiement) {
		boolean isAdded = false;
		try {
			openTransaction();
			entityManager.persist(paiement);
			entityTransaction.commit();
			closeTransaction();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}
	
	/**
	 * Récupère tous les paiements
	 * @return
	 */
	public List<Paiement> findAll(){
		openTransaction();
		List<Paiement> paiementsList = null;
		String queryString = "From Paiement";
		Query query = entityManager.createQuery(queryString);
		
		if(query.getResultList().size() != 0) {
			paiementsList = (List<Paiement>) query.getResultList();
		}
		closeTransaction();
		return paiementsList;
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
