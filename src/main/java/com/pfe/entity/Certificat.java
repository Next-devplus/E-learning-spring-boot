package com.pfe.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="certificat")
public class Certificat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	 
	
	
	
	@Column(name="duree")
	private String duree;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_examen", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private Examen examen;

	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_apprenant", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private Apprenant apprenant;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getDuree() {
		return duree;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	
	public Examen getExamen() {
		return examen;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	 
	
	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}
	 
	

}
