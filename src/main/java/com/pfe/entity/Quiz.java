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
@Table(name="quiz")
public class Quiz implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="note")
	private String note;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chapitre", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Chapitre chapitre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Question question;
	
	public Chapitre getChapitre() {
		
		
		return chapitre;
	}

	
	
	
	
public Question getQuestion() {
		
		
		return question;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	 

	public void setId(int id) {
		this.id = id;
	}

	public void setNote(String note) {
		this.note = note;
	}

	 
	 

}
