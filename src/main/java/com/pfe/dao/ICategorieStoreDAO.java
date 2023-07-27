package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Categorie;

public interface ICategorieStoreDAO {
	
	List<Categorie> getCategories();
	Categorie getCategorie(int CategorieId);
	Categorie createCategorie(Categorie Categorie);
	Categorie updateCategorie(int CategorieId,Categorie Categorie);
	boolean deleteCategorie(int CategorieId);

}
