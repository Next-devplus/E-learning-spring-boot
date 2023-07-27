package com.pfe.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="examen")
public class Examen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="note")
	private String note;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_module", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Module module;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_apprenant", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Apprenant apprenant;
	
 
	
	@OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
	@JsonManagedReference
    private Set<Question> question;
	
		public Set<Question> getQuestion() {
        return question;
    }
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Set<Question> getQuestion() {
        return question;
    }
	
	
	public int getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	public Module getModule() {
		return module;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	  
}
