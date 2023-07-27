package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Chapitre;

public interface IChapitreStoreDAO {
	
	List<Chapitre> getChapitres();
	Chapitre getChapitre(int ChapitreId);
	Chapitre createChapitre(Chapitre Chapitre);
	Chapitre updateChapitre(int ChapitreId,Chapitre Chapitre);
	boolean deleteChapitre(int ChapitreId);

}
