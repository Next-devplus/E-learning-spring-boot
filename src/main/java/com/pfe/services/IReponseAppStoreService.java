package com.pfe.services;

import java.util.List;

import com.pfe.entity.ReponseApp;

public interface IReponseAppStoreService {
	
	List<ReponseApp> getReponseApps();
	ReponseApp createReponseApp(ReponseApp ReponseApp);
	ReponseApp updateReponseApp(int ReponseAppId, ReponseApp ReponseApp);
	ReponseApp getReponseApp(int ReponseAppId);
	boolean deleteReponseApp(int ReponseAppId);

}
