package com.pfe.services;

import java.util.List;

import com.pfe.entity.Reponse;

public interface IReponseStoreService {
	
	List<Reponse> getReponses();
	Reponse createReponse(Reponse Reponse);
	Reponse updateReponse(int ReponseId, Reponse Reponse);
	Reponse getReponse(int ReponseId);
	boolean deleteReponse(int ReponseId);

}
