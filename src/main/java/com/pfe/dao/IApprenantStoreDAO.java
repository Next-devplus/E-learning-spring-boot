package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Apprenant;

public interface IApprenantStoreDAO {
	
	List<Apprenant> getApprenants();
	Apprenant getApprenant(int ApprenantId);
	Apprenant createApprenant(Apprenant Apprenant);
	Apprenant updateApprenant(int ApprenantId,Apprenant Apprenant);
	boolean deleteApprenant(int ApprenantId);

}
