package bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		entityManager = entityManagerFactory.createEntityManager();
		Fournisseur fournisseur = entityManager.find(Fournisseur.class, id);
		entityManager.close();
		return fournisseur;
	}

	/**
	 * Récupère la liste des fournisseurs
	 * 
	 * @param id
	 * @return List<Fournisseur>
	 */
	public List<Fournisseur> getFournisseurs() {
		entityManager = entityManagerFactory.createEntityManager();
		String queryString = "FROM Fournisseur";
		Query query = entityManager.createQuery(queryString);

		List<Fournisseur> listeFournisseurs = query.getResultList();

		entityManager.close();
		return listeFournisseurs;
	}
}
