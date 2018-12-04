package fr.ensai.projetWE.business;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({@NamedQuery(name="touslesutilisateurs",query="select u from User as u"),
	@NamedQuery(name="touslesutilisateursparnom",query="select u from User as u where u.name=:name")
})

@Entity
public class User {
	
	
	@Id@GeneratedValue
	long id;
	
	String nom, prenom;
	Date datenaissance;
	ROLE role;
	
	@ManyToMany
	List<Activite> sportspreferes;

	@OneToMany
	@JoinColumn(name="userid")
	List<ActiviteHistorique> historiques;
	
	public List<ActiviteHistorique> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<ActiviteHistorique> historiques) {
		this.historiques = historiques;
	}
	public List<Activite> getSportspreferes() {
		return sportspreferes;
	}
	public void setSportspreferes(List<Activite> sportspreferes) {
		this.sportspreferes = sportspreferes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public ROLE getRole() {
		return role;
	}
	public void setRole(ROLE role) {
		this.role = role;
	}
	
	
}
