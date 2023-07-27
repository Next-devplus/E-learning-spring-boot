package com.pfe.services;

import java.util.List;

import com.pfe.entity.Blanc;

public interface IBlancStoreService {
	
	List<Blanc> getBlancs();
	Blanc createBlanc(Blanc Blanc);
	Blanc updateBlanc(int BlancId, Blanc Blanc);
	Blanc getBlanc(int BlancId);
	boolean deleteBlanc(int BlancId);

}
