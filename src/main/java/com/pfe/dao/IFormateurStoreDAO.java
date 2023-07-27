package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Formateur;

public interface IFormateurStoreDAO {
	
	List<Formateur> getFormateurs();
	Formateur getFormateur(int FormateurId);
	Formateur createFormateur(Formateur Formateur);
	Formateur updateFormateur(int FormateurId,Formateur Formateur);
	boolean deleteFormateur(int FormateurId);

}
