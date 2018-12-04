package fr.ensai.projetWE.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.ROLE;
import fr.ensai.projetWE.business.User;

public class UserDao {

	public User findById(long id) {
		return EntityManagerHelper.getEntityManager().find(User.class, id);
	}

	public User save(User u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	public List<User> getAll() {
		// return EntityManagerHelper.getEntityManager().createQuery("select u from User
		// u").getResultList();
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();

		CriteriaQuery<User> q = cb.createQuery(User.class);
		Root<User> c = q.from(User.class);
		return EntityManagerHelper.getEntityManager().createQuery(q.select(c)).getResultList();
	}

	public List<User> getUserByName(String name) {
		return EntityManagerHelper.getEntityManager().createNamedQuery("touslesutilisateursparnom")
				.setParameter("nom", name).setFirstResult(0).setMaxResults(60).getResultList();

	}

	public User delete(User u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().remove(u);
		EntityManagerHelper.commit();
		return u;
	}

	List<User> getUserByActivity(String name) {

		String query = "select u from User as u join u.sportspreferes as s where s.activityname=:name";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("name", name)
				.getResultList();

	}
	
	List<User> getAdmin() {

		String query = "select u from User as u where u.role=:role";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("role", ROLE.ADMIN)
				.getResultList();

	}

	
	List<User> getUserByLieu(String name) {

		String query = "select u from User as u join u.sportspreferes as s join s.lieux as l where l.name=:name";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("name", name)
				.getResultList();

	}

	List<User> getUserByCodePostal(String codepostal) {

		String query = "select u from User as u join u.sportspreferes as s join s.lieux as l where l.codePostal=:codepostal";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("codepostal", codepostal)
				.getResultList();

	}


}
