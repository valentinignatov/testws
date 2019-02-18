package com.mkyong.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persons {
	private int id;
	private int nr_ordine;
	private String idnp;
	private String name;
	private String surname;
	private String birthday;
	private String buletinseries;
	private String buletinnr;
	
	public Persons(int id,int nr_ordine, String idnp, String name, String surname, String birthday, String buletinseries,
			String buletinnr) {
		super();
		this.id = id;
		this.nr_ordine = nr_ordine;
		this.idnp = idnp;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.buletinseries = buletinseries;
		this.buletinnr = buletinnr;
	}
	
	public Persons() {
		// TODO Auto-generated constructor stub
	}
	public int getNr_ordine() {
		return nr_ordine;
	}

	public void setNr_ordine(int nr_ordine) {
		this.nr_ordine = nr_ordine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdnp() {
		return idnp;
	}
	public void setIdnp(String idnp) {
		this.idnp = idnp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBuletinseries() {
		return buletinseries;
	}
	public void setBuletinseries(String buletinseries) {
		this.buletinseries = buletinseries;
	}
	public String getBuletinnr() {
		return buletinnr;
	}
	public void setBuletinnr(String buletinnr) {
		this.buletinnr = buletinnr;
	}
	
	

}
