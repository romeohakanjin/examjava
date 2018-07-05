package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		entityManager = entityManagerFactory.createEntityManager();
		boolean verificationIdentifiants = false;
		String queryString = "FROM Utilisateur WHERE login ='" + login + "' AND mdp = '" + mdp + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			verificationIdentifiants = true;
		}

		entityManager.close();
		return verificationIdentifiants;
	}

	/**
	 * Récupère un utilisateur grâce à son id
	 * 
	 * @param id
	 * @return utilisateur
	 */
	public Utilisateur findById(int id) {
		entityManager = entityManagerFactory.createEntityManager();

		Utilisateur utilisateur = entityManager.find(Utilisateur.class, id);

		entityManager.close();
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
		entityManager = entityManagerFactory.createEntityManager();
		Utilisateur utilisateur = null;

		String queryString = "FROM Utilisateur WHERE login ='" + login + "' ";
		Query query = entityManager.createQuery(queryString);

		if (query.getResultList().size() != 0) {
			utilisateur = (Utilisateur) query.getSingleResult();
		}

		entityManager.close();
		return utilisateur;
	}
}
