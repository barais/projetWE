package fr.ensai.projetWE;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Activite {
	
	@Id
	@GeneratedValue
	long id;
	
	
	String activityname;
	int minwindcondition;
	int maxwindcondition;
	int mintemperature;
	int maxtemperature;
	boolean canRain;
	boolean mustBeSunny;
	boolean indoor;
	
	
	@ManyToMany
	List<Lieu> lieux;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public int getMinwindcondition() {
		return minwindcondition;
	}

	public void setMinwindcondition(int minwindcondition) {
		this.minwindcondition = minwindcondition;
	}

	public int getMaxwindcondition() {
		return maxwindcondition;
	}

	public void setMaxwindcondition(int maxwindcondition) {
		this.maxwindcondition = maxwindcondition;
	}

	public int getMintemperature() {
		return mintemperature;
	}

	public void setMintemperature(int mintemperature) {
		this.mintemperature = mintemperature;
	}

	public int getMaxtemperature() {
		return maxtemperature;
	}

	public void setMaxtemperature(int maxtemperature) {
		this.maxtemperature = maxtemperature;
	}

	public boolean isCanRain() {
		return canRain;
	}

	public void setCanRain(boolean canRain) {
		this.canRain = canRain;
	}

	public boolean isMustBeSunny() {
		return mustBeSunny;
	}

	public void setMustBeSunny(boolean mustBeSunny) {
		this.mustBeSunny = mustBeSunny;
	}

	public boolean isIndoor() {
		return indoor;
	}

	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}

	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
	
}
