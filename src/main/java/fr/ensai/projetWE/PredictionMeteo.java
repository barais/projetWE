package fr.ensai.projetWE;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PredictionMeteo {

	
	
	@Id
	@GeneratedValue
	long id;
	
	boolean	rainy;
	boolean	sunny;
	int temperatureaverage;
	int windaverage;
	Date startDate;
	Date endDate;
	
	Lieu lieu;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isRainy() {
		return rainy;
	}
	public void setRainy(boolean rainy) {
		this.rainy = rainy;
	}
	public boolean isSunny() {
		return sunny;
	}
	public void setSunny(boolean sunny) {
		this.sunny = sunny;
	}
	public int getTemperatureaverage() {
		return temperatureaverage;
	}
	public void setTemperatureaverage(int temperatureaverage) {
		this.temperatureaverage = temperatureaverage;
	}
	public int getWindaverage() {
		return windaverage;
	}
	public void setWindaverage(int windaverage) {
		this.windaverage = windaverage;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + (rainy ? 1231 : 1237);
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (sunny ? 1231 : 1237);
		result = prime * result + temperatureaverage;
		result = prime * result + windaverage;
		return result;
	}
	@Override
	public String toString() {
		return "PredictionMeteo [id=" + id + ", rainy=" + rainy + ", sunny=" + sunny + ", temperatureaverage="
				+ temperatureaverage + ", windaverage=" + windaverage + ", startDate=" + startDate + ", endDate="
				+ endDate + ", lieu=" + lieu + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PredictionMeteo other = (PredictionMeteo) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (rainy != other.rainy)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (sunny != other.sunny)
			return false;
		if (temperatureaverage != other.temperatureaverage)
			return false;
		if (windaverage != other.windaverage)
			return false;
		return true;
	}
}
