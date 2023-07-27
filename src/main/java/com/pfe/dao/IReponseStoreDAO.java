package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Reponse;

public interface IReponseStoreDAO {
	
	List<Reponse> getReponses();
	Reponse getReponse(int ReponseId);
	Reponse createReponse(Reponse Reponse);
	Reponse updateReponse(int ReponseId,Reponse Reponse);
	boolean deleteReponse(int ReponseId);

}
