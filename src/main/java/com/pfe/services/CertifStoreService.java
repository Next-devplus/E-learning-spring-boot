package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.ICertificatStoreDAO;
import com.pfe.entity.Certificat;
 

@Service
public class CertifStoreService implements ICertifStoreService {
	
	@Autowired
	private ICertificatStoreDAO dao;

	@Override
	public List<Certificat> getCertifs() {
		return dao.getCertifs();
	}


	@Override
	public Certificat createCertif(Certificat Certif) {
		return dao.createCertif(Certif);
	}

	@Override
	public Certificat updateCertif(int CertifId, Certificat Certif) {
		return dao.updateCertif(CertifId, Certif);
	}

	@Override
	public Certificat getCertif(int CertifId) {
		return dao.getCertif(CertifId);
	}

	@Override
	public boolean deleteCertif(int CertifId) {
		return dao.deleteCertif(CertifId);
	}

}
