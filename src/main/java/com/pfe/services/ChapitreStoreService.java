package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IChapitreStoreDAO;
import com.pfe.entity.Chapitre;
 

@Service
public class ChapitreStoreService implements IChapitreStoreService {
	
	@Autowired
	private IChapitreStoreDAO dao;

	@Override
	public List<Chapitre> getChapitres() {
		return dao.getChapitres();
	}


	@Override
	public Chapitre createChapitre(Chapitre Chapitre) {
		return dao.createChapitre(Chapitre);
	}

	@Override
	public Chapitre updateChapitre(int ChapitreId, Chapitre Chapitre) {
		return dao.updateChapitre(ChapitreId, Chapitre);
	}

	@Override
	public Chapitre getChapitre(int ChapitreId) {
		return dao.getChapitre(ChapitreId);
	}

	@Override
	public boolean deleteChapitre(int ChapitreId) {
		return dao.deleteChapitre(ChapitreId);
	}

}
