package com.pfe.services;

import java.util.List;

import com.pfe.entity.Formateur;

public interface IFormateurStoreService {
	
	List<Formateur> getFormateurs();
	Formateur createFormateur(Formateur Formateur);
	Formateur updateFormateur(int FormateurId, Formateur Formateur);
	Formateur getFormateur(int FormateurId);
	boolean deleteFormateur(int FormateurId);

}
