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

import entity.Livraison;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class LivraisonSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction entityTransaction;
	private EntityManager entityManager;

	public void ajoutLivraison(Livraison livraison) {
		openTransaction();
		livraison.setDate(Calendar.getInstance().getTime());
		entityManager.persist(livraison);
		entityTransaction.commit();
		closeTransaction();
	}

	/**
	 * Récupère une livraison grâce à son id
	 * 
	 * @param id
	 * @return livraison
	 */
	public Livraison findById(int id) {
		openTransaction();

		Livraison livraison = entityManager.find(Livraison.class, id);

		closeTransaction();
		return livraison;
	}

	/**
	 * Récupère la liste des livraisons
	 * 
	 * @return List<Livraison>
	 */
	public List<Livraison> getLivraisons() {
		openTransaction();
		String queryString = "FROM Livraison";
		Query query = entityManager.createQuery(queryString);

		List<Livraison> listeLivraisons = query.getResultList();

		closeTransaction();
		return listeLivraisons;
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