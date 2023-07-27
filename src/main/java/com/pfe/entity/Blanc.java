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
@Table(name="blanc")
public class Blanc implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	 
	@Column(name="date")
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_examen", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private Examen examen;
      public Examen getExamen() {
		return examen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	 
	public Examen getExamen() {
		return examen;
	}

	public void setId(int id) {
		this.id = id;
	}

	 

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	 
	

}
