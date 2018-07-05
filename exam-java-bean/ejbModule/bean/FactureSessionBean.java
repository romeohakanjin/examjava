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
	 * Récupère une facture pour une commande donnée
	 * 
	 * @param idCommande
	 * @return
	 */
	public Facture findByIdCommande(int idCommande) {
		entityManager = entityManagerFactory.createEntityManager();
		Facture facture = null;
		String queryString = "FROM Facture WHERE idCommande ='" + idCommande + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			facture = (Facture) query.getSingleResult();
		}

		entityManager.close();
		return facture;
	}

	/**
	 * Ajout d'une facture
	 * 
	 * @param idCommande
	 * @return
	 */
	public boolean ajoutFacture(Facture facture) {
		boolean isAdded = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.persist(facture);

			entityTransaction.commit();
			entityManager.close();
			isAdded = true;
		} catch (Exception e) {
			isAdded = false;
		}

		return isAdded;
	}

	/**
	 * Récupère une facture grâce à son id
	 * 
	 * @param id
	 * @return facture
	 */
	public Facture findById(int id) {
		entityManager = entityManagerFactory.createEntityManager();

		Facture facture = entityManager.find(Facture.class, id);

		entityManager.close();
		return facture;
	}

	/**
	 * Récupère la liste des factures
	 * 
	 * @return List<Facture>
	 */
	public List<Facture> getFactures() {
		entityManager = entityManagerFactory.createEntityManager();
		String queryString = "FROM Facture";
		Query query = entityManager.createQuery(queryString);

		List<Facture> listeFactures = query.getResultList();

		entityManager.close();
		return listeFactures;
	}
}
