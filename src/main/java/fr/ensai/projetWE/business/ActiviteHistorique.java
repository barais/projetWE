package fr.ensai.projetWE.business;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ActiviteHistorique {
	
	@Id
	@GeneratedValue
	long id;
	@ManyToOne
	Activite activite;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Activite getActivite() {
		return activite;
	}
	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	
	Date date;
	
	@ManyToOne
	Lieu lieu;

}
