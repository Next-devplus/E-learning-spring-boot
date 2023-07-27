package com.pfe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="paiement")
public class Paiement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private String date;
	
 
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_apprenant", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Apprenant apprenant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_module", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Module module;
	
	
	
	
public Module getModule() {
		
		
		return module;
	}



public Apprenant getApprenant() {
	
	
	return apprenant;
}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}


	public String getDate() {
		return date;
	}


	 


	public void setId(int id) {
		this.id = id;
	}


	public void setDate(String date) {
		this.date = date;
	}


	 
	
	 
}
