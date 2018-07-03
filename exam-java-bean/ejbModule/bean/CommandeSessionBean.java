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

import entity.Commande;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class CommandeSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;
	
	/**
	 * R�cup�re la liste de toutes les commandes
	 * @return
	 */
	public List<Commande> findAll(){
		openTransaction();
		List<Commande> commandeList = null;
		String queryString = "FROM Commande";
		Query query = entityManager.createQuery(queryString);
		
		if(query.getResultList().size() != 0) {
			commandeList = (List<Commande>) query.getResultList();
		}
		
		closeTransaction();
		return commandeList;
	}
	
	/**
	 * R�cup�re une commande gr�ce � son id
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