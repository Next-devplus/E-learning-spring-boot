package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IPaiementStoreDAO;
import com.pfe.entity.Paiement;

@Service
public class PaiementStoreService implements IPaiementStoreService {
	
	@Autowired
	private IPaiementStoreDAO dao;

	@Override
	public List<Paiement> getPaiements() {
		return dao.getPaiements();
	}

	@Override
	public Paiement createPaiement(Paiement Paiement) {
		return dao.createPaiement(Paiement);
	}

	@Override
	public Paiement updatePaiement(int PaiementId, Paiement Paiement) {
		return dao.updatePaiement(PaiementId, Paiement);
	}

	@Override
	public Paiement getPaiement(int PaiementId) {
		return dao.getPaiement(PaiementId);
	}

	@Override
	public boolean deletePaiement(int PaiementId) {
		return dao.deletePaiement(PaiementId);
	}

}
