package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IBlancStoreDAO;
import com.pfe.entity.Blanc;
 

@Service
public class BlancStoreService implements IBlancStoreService {
	
	@Autowired
	private IBlancStoreDAO dao;

	@Override
	public List<Blanc> getBlancs() {
		return dao.getBlancs();
	}


	@Override
	public Blanc createBlanc(Blanc Blanc) {
		return dao.createBlanc(Blanc);
	}

	@Override
	public Blanc updateBlanc(int BlancId, Blanc Blanc) {
		return dao.updateBlanc(BlancId, Blanc);
	}

	@Override
	public Blanc getBlanc(int BlancId) {
		return dao.getBlanc(BlancId);
	}

	@Override
	public boolean deleteBlanc(int BlancId) {
		return dao.deleteBlanc(BlancId);
	}

}
