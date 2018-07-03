package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import entity.Utilisateur;

@Stateful
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateurSessionBean {

	@PersistenceUnit(unitName = "coucheAvecJPA")
	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	/**
	 * Vérifie les identifiants de connexion
	 * 
	 * @param login
	 *            : identifiant
	 * @param mdp
	 *            : mot de passe
	 * @return boolean : True si les identifiants correspondent
	 */
	public boolean verificationIdentifiants(String login, String mdp) {
		boolean verificationIdentifiants = false;
		openTransaction();
		String queryString = "FROM Utilisateur WHERE login ='" + login + "' AND mdp = '" + mdp + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			verificationIdentifiants = true;
		}

		closeTransaction();
		return verificationIdentifiants;
	}

	/**
	 * Récupère un utilisateur grâce à son id
	 * 
	 * @param id
	 * @return utilisateur
	 */
	public Utilisateur findById(int id) {
		openTransaction();

		Utilisateur utilisateur = entityManager.find(Utilisateur.class, id);
		
		closeTransaction();
		return utilisateur;
	}

	/**
	 * Récupère un utilisateur grâce à son login
	 * 
	 * @param login
	 *            : identifiant
	 * @return utilisateur
	 */
	public Utilisateur findByLogin(String login) {
		openTransaction();
		Utilisateur utilisateur = null;

		String queryString = "FROM Utilisateur WHERE login ='" + login + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			utilisateur = (Utilisateur) query.getSingleResult();
		}

		closeTransaction();
		return utilisateur;
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
