package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Certificat;

public interface ICertificatStoreDAO {
	
	List<Certificat> getCertifs();
	Certificat getCertif(int CertifId);
	Certificat createCertif(Certificat Certif);
	Certificat updateCertif(int CertifId,Certificat Certif);
	boolean deleteCertif(int CertifId);

}
