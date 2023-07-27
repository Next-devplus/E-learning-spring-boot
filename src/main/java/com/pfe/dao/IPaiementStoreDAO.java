package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Paiement;

public interface IPaiementStoreDAO {
	
	List<Paiement> getPaiements();
	Paiement getPaiement(int PaiementId);
	Paiement createPaiement(Paiement Paiement);
	Paiement updatePaiement(int PaiementId,Paiement Paiement);
	boolean deletePaiement(int PaiementId);

}
