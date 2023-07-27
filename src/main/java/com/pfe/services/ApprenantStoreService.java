package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IApprenantStoreDAO;
import com.pfe.entity.Apprenant;

@Service
public class ApprenantStoreService implements IApprenantStoreService {
	
	@Autowired
	private IApprenantStoreDAO dao;

	@Override
	public List<Apprenant> getApprenants() {
		return dao.getApprenants();
	}

	@Override
	public Apprenant createApprenant(Apprenant Apprenant) {
		return dao.createApprenant(Apprenant);
	}

	@Override
	public Apprenant updateApprenant(int ApprenantId, Apprenant Apprenant) {
		return dao.updateApprenant(ApprenantId, Apprenant);
	}

	@Override
	public Apprenant getApprenant(int ApprenantId) {
		return dao.getApprenant(ApprenantId);
	}

	@Override
	public boolean deleteApprenant(int ApprenantId) {
		return dao.deleteApprenant(ApprenantId);
	}

}
