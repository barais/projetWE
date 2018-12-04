package fr.ensai.projetWE.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.Lieu;
import fr.ensai.projetWE.business.ROLE;
import fr.ensai.projetWE.business.User;

public class LieuDao {

	public Lieu findById(long id) {
		return EntityManagerHelper.getEntityManager().find(Lieu.class, id);
	}

	public Lieu save(Lieu u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	public List<Lieu> getAll() {
		// return EntityManagerHelper.getEntityManager().createQuery("select u from User
		// u").getResultList();
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();

		CriteriaQuery<Lieu> q = cb.createQuery(Lieu.class);
		Root<Lieu> c = q.from(Lieu.class);
		return EntityManagerHelper.getEntityManager().createQuery(q.select(c)).getResultList();
	}


	public Lieu delete(Lieu u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().remove(u);
		EntityManagerHelper.commit();
		return u;
	}



}
