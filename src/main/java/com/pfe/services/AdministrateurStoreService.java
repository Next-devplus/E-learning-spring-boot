package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IAdministrateurStoreDAO;
import com.pfe.entity.Administrateur;

@Service
public class AdministrateurStoreService implements IAdministrateurStoreService {
	
	@Autowired
	private IAdministrateurStoreDAO dao;

	@Override
	public List<Administrateur> getAdministrateurs() {
		return dao.getAdministrateurs();
	}

	@Override
	public Administrateur createAdministrateur(Administrateur Administrateur) {
		return dao.createAdministrateur(Administrateur);
	}

	@Override
	public Administrateur updateAdministrateur(int AdministrateurId, Administrateur Administrateur) {
		return dao.updateAdministrateur(AdministrateurId, Administrateur);
	}

	@Override
	public Administrateur getAdministrateur(int AdministrateurId) {
		return dao.getAdministrateur(AdministrateurId);
	}

	@Override
	public boolean deleteAdministrateur(int AdministrateurId) {
		return dao.deleteAdministrateur(AdministrateurId);
	}
	
 
	
	

}
