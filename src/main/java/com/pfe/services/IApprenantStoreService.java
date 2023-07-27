package com.pfe.services;

import java.util.List;

import com.pfe.entity.Apprenant;

public interface IApprenantStoreService {
	
	List<Apprenant> getApprenants();
	Apprenant createApprenant(Apprenant Apprenant);
	Apprenant updateApprenant(int ApprenantId, Apprenant Apprenant);
	Apprenant getApprenant(int ApprenantId);
	boolean deleteApprenant(int ApprenantId);

}
