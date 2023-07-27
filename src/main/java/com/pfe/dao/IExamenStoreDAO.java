package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Examen;

public interface IExamenStoreDAO {
	
	List<Examen> getExamens();
	Examen getExamen(int ExamenId);
	Examen createExamen(Examen Examen);
	Examen updateExamen(int ExamenId,Examen Examen);
	boolean deleteExamen(int ExamenId);

}
