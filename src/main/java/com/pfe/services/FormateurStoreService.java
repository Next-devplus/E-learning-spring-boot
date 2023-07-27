package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IFormateurStoreDAO;
import com.pfe.entity.Formateur;

@Service
public class FormateurStoreService implements IFormateurStoreService {
	
	@Autowired
	private IFormateurStoreDAO dao;

	@Override
	public List<Formateur> getFormateurs() {
		return dao.getFormateurs();
	}

	@Override
	public Formateur createFormateur(Formateur Formateur) {
		return dao.createFormateur(Formateur);
	}

	@Override
	public Formateur updateFormateur(int FormateurId, Formateur Formateur) {
		return dao.updateFormateur(FormateurId, Formateur);
	}

	@Override
	public Formateur getFormateur(int FormateurId) {
		return dao.getFormateur(FormateurId);
	}

	@Override
	public boolean deleteFormateur(int FormateurId) {
		return dao.deleteFormateur(FormateurId);
	}

}
