package com.pfe.services;

import java.util.List;

import com.pfe.entity.Examen;

public interface IExamenStoreService {
	
	List<Examen> getExamens();
	Examen createExamen(Examen Examen);
	Examen updateExamen(int ExamenId, Examen Examen);
	Examen getExamen(int ExamenId);
	boolean deleteExamen(int ExamenId);

}
