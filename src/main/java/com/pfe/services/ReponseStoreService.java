package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IReponseStoreDAO;
import com.pfe.entity.Reponse;
 

@Service
public class ReponseStoreService implements IReponseStoreService {
	
	@Autowired
	private IReponseStoreDAO dao;

	@Override
	public List<Reponse> getReponses() {
		return dao.getReponses();
	}


	@Override
	public Reponse createReponse(Reponse Reponse) {
		return dao.createReponse(Reponse);
	}

	@Override
	public Reponse updateReponse(int ReponseId, Reponse Reponse) {
		return dao.updateReponse(ReponseId, Reponse);
	}

	@Override
	public Reponse getReponse(int ReponseId) {
		return dao.getReponse(ReponseId);
	}

	@Override
	public boolean deleteReponse(int ReponseId) {
		return dao.deleteReponse(ReponseId);
	}

}
