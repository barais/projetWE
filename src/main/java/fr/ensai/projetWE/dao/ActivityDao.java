package fr.ensai.projetWE.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.Activite;
import fr.ensai.projetWE.business.User;

public class ActivityDao {

	Activite findById(long id) {
		return EntityManagerHelper.getEntityManager().find(Activite.class, id);
	}

	Activite save(Activite u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	List<Activite> getAll() {
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Activite> q = cb.createQuery(Activite.class);
		Root<Activite> c = q.from(Activite.class);
		return EntityManagerHelper.getEntityManager().createQuery(q.select(c)).getResultList();
	}


	Activite delete(Activite a) {

		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(a);
		EntityManagerHelper.commit();
		return a;
	}

	List<Activite> getActivityByUser(String name) {

		String query = "select distinct u.sportspreferes from User as u where u.nom=:nom";
		return EntityManagerHelper.getEntityManager().createQuery(query, Activite.class).setParameter("nom", name)
				.getResultList();

	}
	
	List<Activite> getActivityByLieu(String name) {

		String query = "select a from Activite as a join a.lieux as l where l.name=:name";
		return EntityManagerHelper.getEntityManager().createQuery(query, Activite.class).setParameter("name", name)
				.getResultList();

	}

	List<Activite> getActiviteByCodePostal(String codepostal) {
		String query = "select a from Activite as a join a.lieux as l where l.codePostal=:codepostal";
		return EntityManagerHelper.getEntityManager().createQuery(query, Activite.class).setParameter("codepostal", codepostal)
				.getResultList();

	}


}
