package com.pfe.services;

import java.util.List;

import com.pfe.entity.Paiement;

public interface IPaiementStoreService {
	
	List<Paiement> getPaiements();
	Paiement createPaiement(Paiement Paiement);
	Paiement updatePaiement(int PaiementId, Paiement Paiement);
	Paiement getPaiement(int PaiementId);
	boolean deletePaiement(int PaiementId);

}
