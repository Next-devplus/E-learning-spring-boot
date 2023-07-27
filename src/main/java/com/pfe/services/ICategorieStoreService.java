package com.pfe.services;

import java.util.List;

import com.pfe.entity.Categorie;

public interface ICategorieStoreService {
	
	List<Categorie> getCategories();
	Categorie createCategorie(Categorie Categorie);
	Categorie updateCategorie(int CategorieId, Categorie Categorie);
	Categorie getCategorie(int CategorieId);
	boolean deleteCategorie(int CategorieId);

}
