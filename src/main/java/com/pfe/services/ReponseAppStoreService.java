package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.IReponseAppStoreDAO;
import com.pfe.entity.ReponseApp;
 

@Service
public class ReponseAppStoreService implements IReponseAppStoreService {
	
	@Autowired
	private IReponseAppStoreDAO dao;

	@Override
	public List<ReponseApp> getReponseApps() {
		return dao.getReponseApps();
	}


	@Override
	public ReponseApp createReponseApp(ReponseApp ReponseApp) {
		return dao.createReponseApp(ReponseApp);
	}

	@Override
	public ReponseApp updateReponseApp(int ReponseAppId, ReponseApp ReponseApp) {
		return dao.updateReponseApp(ReponseAppId, ReponseApp);
	}

	@Override
	public ReponseApp getReponseApp(int ReponseAppId) {
		return dao.getReponseApp(ReponseAppId);
	}

	@Override
	public boolean deleteReponseApp(int ReponseAppId) {
		return dao.deleteReponseApp(ReponseAppId);
	}

}
