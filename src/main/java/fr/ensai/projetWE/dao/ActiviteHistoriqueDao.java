package fr.ensai.projetWE.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fr.ensai.projetWE.EntityManagerHelper;
import fr.ensai.projetWE.business.ActiviteHistorique;

public class ActiviteHistoriqueDao {

	ActiviteHistorique findById(long id) {
		return EntityManagerHelper.getEntityManager().find(ActiviteHistorique.class, id);
	}

	ActiviteHistorique save(ActiviteHistorique u) {

		EntityManagerHelper.beginTransaction();

		EntityManagerHelper.getEntityManager().persist(u);
		EntityManagerHelper.commit();
		return u;
	}

	List<ActiviteHistorique> getAll() {
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ActiviteHistorique> q = cb.createQuery(ActiviteHistorique.class);
		Root<ActiviteHistorique> c = q.from(ActiviteHistorique.class);
		return EntityManagerHelper.getEntityManager().createQuery(q.select(c)).getResultList();
	}


	ActiviteHistorique delete(ActiviteHistorique a) {

		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(a);
		EntityManagerHelper.commit();
		return a;
	}

	List<ActiviteHistorique> getActiviteHistoriqueByUser(String name) {

		String query = "select distinct u.historiques from  User as u where u.name=:nom";
		return EntityManagerHelper.getEntityManager().createQuery(query, ActiviteHistorique.class).setParameter("nom", name)
				.getResultList();

	}
	
	
	List<ActiviteHistorique> getActiviteHistoriqueByUser(String name, String lieu) {

		String query = "select distinct u.historiques from  User as u join u.historiques as ah where u.name=:nom and u.lieu.name=:lieu" ;
		return EntityManagerHelper.getEntityManager().createQuery(query, ActiviteHistorique.class).setParameter("nom", name).setParameter("lieu", lieu)
				.getResultList();

	}



}
