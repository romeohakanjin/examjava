package bean;

import java.util.Calendar;
import java.util.Date;
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
	
	private EntityTransaction entityTransaction;
	
	/**
	 * Récupère une facture pour une commande donnée
	 * @param idCommande
	 * @return
	 */
	public Facture findByIdCommande(int idCommande) {
		openTransaction();
		Facture facture = null;
		String queryString = "FROM Facture WHERE idCommande ='" + idCommande + "' ";
		Query query = entityManager.createQuery(queryString);
		
		if(query.getResultList().size() != 0) {
			facture = (Facture) query.getSingleResult();
		}

		closeTransaction();
		return facture;
	}
	
	/**
	 * Ajout d'une facture
	 * @param idCommande
	 * @return
	 */
	public boolean ajoutFacture(int idCommande){
		openTransaction();
		boolean isAdded = false;
		try {
			Facture facture = new Facture();
			facture.setIdCommande(idCommande);
			facture.setDate(Calendar.getInstance().getTime());
			entityManager.persist(facture);
			entityTransaction.commit();
			closeTransaction();
			isAdded = true;
		}catch(Exception e) {
			e.printStackTrace();
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
		openTransaction();
		String queryString = "FROM Facture WHERE id ='" + id + "' ";

		Facture facture = entityManager.find(Facture.class, id);

		closeTransaction();
		return facture;
	}

	/**
	 * Récupère la liste des factures
	 * 
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
