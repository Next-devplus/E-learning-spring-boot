package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Blanc;

public interface IBlancStoreDAO {
	
	List<Blanc> getBlancs();
	Blanc getBlanc(int BlancId);
	Blanc createBlanc(Blanc Blanc);
	Blanc updateBlanc(int BlancId,Blanc Blanc);
	boolean deleteBlanc(int BlancId);

}
