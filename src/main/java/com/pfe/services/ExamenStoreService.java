package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IExamenStoreDAO;
import com.pfe.entity.Examen;
 

@Service
public class ExamenStoreService implements IExamenStoreService {
	
	@Autowired
	private IExamenStoreDAO dao;

	@Override
	public List<Examen> getExamens() {
		return dao.getExamens();
	}


	@Override
	public Examen createExamen(Examen Examen) {
		return dao.createExamen(Examen);
	}

	@Override
	public Examen updateExamen(int ExamenId, Examen Examen) {
		return dao.updateExamen(ExamenId, Examen);
	}

	@Override
	public Examen getExamen(int ExamenId) {
		return dao.getExamen(ExamenId);
	}

	@Override
	public boolean deleteExamen(int ExamenId) {
		return dao.deleteExamen(ExamenId);
	}

}
