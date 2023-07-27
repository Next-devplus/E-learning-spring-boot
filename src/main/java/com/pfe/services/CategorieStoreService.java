package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.ICategorieStoreDAO;
import com.pfe.entity.Categorie;
 
@Service
public class CategorieStoreService implements ICategorieStoreService {
	
	@Autowired
	private ICategorieStoreDAO dao;

	@Override
	public List<Categorie> getCategories() {
		return dao.getCategories();
	}


	@Override
	public Categorie createCategorie(Categorie Categorie) {
		return dao.createCategorie(Categorie);
	}

	@Override
	public Categorie updateCategorie(int CategorieId, Categorie Categorie) {
		return dao.updateCategorie(CategorieId, Categorie);
	}

	@Override
	public Categorie getCategorie(int CategorieId) {
		return dao.getCategorie(CategorieId);
	}

	@Override
	public boolean deleteCategorie(int CategorieId) {
		return dao.deleteCategorie(CategorieId);
	}

}
