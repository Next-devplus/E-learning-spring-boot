package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Choix;

public interface IChoixStoreDAO {
	
	List<Choix> getChoixs();
	Choix getChoix(int ChoixId);
	Choix createChoix(Choix Choix);
	Choix updateChoix(int ChoixId,Choix Choix);
	boolean deleteChoix(int ChoixId);

}
