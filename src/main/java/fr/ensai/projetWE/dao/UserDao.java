package fr.ensai.projetWE.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.User;

public class UserDao {

	User findById(long id) {
		return EntityManagerHelper.getEntityManager().find(User.class, id);
	}

	User save(User u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	List<User> getAll() {
		// return EntityManagerHelper.getEntityManager().createQuery("select u from User
		// u").getResultList();
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();

		CriteriaQuery<User> q = cb.createQuery(User.class);
		Root<User> c = q.from(User.class);
		return EntityManagerHelper.getEntityManager().createQuery(q.select(c)).getResultList();
	}

	List<User> getUserByName(String name) {
		return EntityManagerHelper.getEntityManager().createNamedQuery("touslesutilisateursparnom")
				.setParameter("nom", name).setFirstResult(0).setMaxResults(60).getResultList();

	}

	User delete(User u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().remove(u);
		EntityManagerHelper.commit();
		return u;
	}

	List<User> getUserByActivity(String name) {

		String query = "select u from User as u join u.sportspreferes as s where s.activityname=:name";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("nom", name)
				.getResultList();

	}
	
	List<User> getUserByLieu(String name) {

		String query = "select u from User as u join u.sportspreferes as s join s.lieux as l where l.name=:name";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("nom", name)
				.getResultList();

	}

	List<User> getUserByCodePostal(String codepostal) {

		String query = "select u from User as u join u.sportspreferes as s join s.lieux as l where l.codePostal=:codepostal";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("codepostal", codepostal)
				.getResultList();

	}


}
