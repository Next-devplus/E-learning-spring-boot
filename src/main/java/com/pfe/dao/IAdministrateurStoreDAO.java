package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Administrateur;

public interface IAdministrateurStoreDAO {
	
	List<Administrateur> getAdministrateurs();
	Administrateur getAdministrateur(int AdministrateurId);
	Administrateur createAdministrateur(Administrateur Administrateur);
	Administrateur updateAdministrateur(int AdministrateurId,Administrateur Administrateur);
	boolean deleteAdministrateur(int AdministrateurId);

}
