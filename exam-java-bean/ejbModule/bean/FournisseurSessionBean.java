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

import entity.Fournisseur;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class FournisseurSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	/**
	 * R�cup�re un fournisseur gr�ce � son id
	 * 
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
	 * Récupère la liste des fournisseurs
	 * 
	 * @param id
	 * @return List<Fournisseur>
	 */
	public List<Fournisseur> getFournisseurs() {
		openTransaction();
		String queryString = "FROM Fournisseur";
		Query query = entityManager.createQuery(queryString);

		List<Fournisseur> listeFournisseurs = query.getResultList();

		closeTransaction();
		return listeFournisseurs;
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
