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
@Table(name="choix")
public class Choix implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Question question;
	 
	
	
	
	
	
public Question getQuestion() {
		
		
		return question;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	 
	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	 

}
