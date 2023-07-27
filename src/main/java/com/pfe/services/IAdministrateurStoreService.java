package com.pfe.services;

import java.util.List;

import com.pfe.entity.Administrateur;

public interface IAdministrateurStoreService {
	
	List<Administrateur> getAdministrateurs();
	Administrateur createAdministrateur(Administrateur Administrateur);
	Administrateur updateAdministrateur(int AdministrateurId, Administrateur Administrateur);
	Administrateur getAdministrateur(int AdministrateurId);
	boolean deleteAdministrateur(int AdministrateurId);
	 
}
