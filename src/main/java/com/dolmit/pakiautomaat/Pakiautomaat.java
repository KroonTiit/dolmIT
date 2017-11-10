package com.dolmit.pakiautomaat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pakiautomaat {
	@Id @GeneratedValue
	private Long id;
	private String riik;
	private int openfrom;
	private int closedfrom;
	private boolean active;
	private String name;
	private int skoor;
	
	public Pakiautomaat() {} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRiik() {
		return riik;
	}
	public void setRiik(String riik) {
		this.riik = riik;
	}
	public int getOpenfrom() {
		return openfrom;
	}
	public void setOpenfrom(int openfrom) {
		this.openfrom = openfrom;
	}
	public int getClosedfrom() {
		return closedfrom;
	}
	public void setClosedfrom(int closedfrom) {
		this.closedfrom = closedfrom;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSkoor() {
		return skoor;
	}
	public void setSkoor(int skoor) {
		this.skoor = skoor;
	}
}
