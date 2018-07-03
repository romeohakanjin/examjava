package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import entity.Fournisseur;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class FournisseurSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;
	
	/**
	 * Récupère un fournisseur grâce à son id
	 * @param id
	 * @return
	 */
	public Fournisseur findById(int id) {
		openTransaction();
		Fournisseur fournisseur = entityManager.find(Fournisseur.class, id);
		closeTransaction();
		return fournisseur;
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
