package fr.ensai.projetWE.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.Lieu;
import fr.ensai.projetWE.business.PredictionMeteo;
import fr.ensai.projetWE.business.ROLE;
import fr.ensai.projetWE.business.User;

public class PredictionMeteoDao {

	public PredictionMeteo findById(long id) {
		return EntityManagerHelper.getEntityManager().find(PredictionMeteo.class, id);
	}

	public PredictionMeteo save(PredictionMeteo u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	public List<PredictionMeteo> getAll() {
		// return EntityManagerHelper.getEntityManager().createQuery("select u from User
		// u").getResultList();
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();

		CriteriaQuery<PredictionMeteo> q = cb.createQuery(PredictionMeteo.class);
		Root<PredictionMeteo> c = q.from(PredictionMeteo.class);
		return EntityManagerHelper.getEntityManager().createQuery(q.select(c)).getResultList();
	}


	public PredictionMeteo delete(PredictionMeteo u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().remove(u);
		EntityManagerHelper.commit();
		return u;
	}

	
/*	public getPredictionBetweenDate(Date before, Date after) {
		String query = "select s from PredictionMeteo as s where s.startDate"
				
				
	}*/


}
