package com.pfe.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.services.ICategorieStoreService;



@Entity
@Table(name="module")
public class Module implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="plan")
	private String plan;
	
	@Column(name="prix")
	private String prix;
	
	@Column(name="description")
	private String description;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categorie", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Categorie categorie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_formateur", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
    private Formateur formateur;
	  
	
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNom() {
		return nom;
	}

	public String getPlan() {
		return plan;
	}

	public String getPrix() {
		return prix;
	}
	
	public Categorie getCategorie() {
		
	
		return categorie;
	}
	
	public Formateur getFormateur() {
		
		
		return formateur;
	}

	public String getDescription() {
		return description;
	}
 

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	 

	 

	

}
