package com.pfe.services;

import java.util.List;

import com.pfe.entity.Choix;

public interface IChoixStoreService {
	
	List<Choix> getChoixs();
	Choix createChoix(Choix Choix);
	Choix updateChoix(int ChoixId, Choix Choix);
	Choix getChoix(int ChoixId);
	boolean deleteChoix(int ChoixId);

}
