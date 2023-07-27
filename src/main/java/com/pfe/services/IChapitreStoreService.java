package com.pfe.services;

import java.util.List;

import com.pfe.entity.Chapitre;

public interface IChapitreStoreService {
	
	List<Chapitre> getChapitres();
	Chapitre createChapitre(Chapitre Chapitre);
	Chapitre updateChapitre(int ChapitreId, Chapitre Chapitre);
	Chapitre getChapitre(int ChapitreId);
	boolean deleteChapitre(int ChapitreId);

}
