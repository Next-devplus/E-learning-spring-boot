package com.pfe.services;

import java.util.List;

import com.pfe.entity.Certificat;

public interface ICertifStoreService {
	
	List<Certificat> getCertifs();
	Certificat createCertif(Certificat Certif);
	Certificat updateCertif(int CertifId, Certificat Certif);
	Certificat getCertif(int CertifId);
	boolean deleteCertif(int CertifId);

}
