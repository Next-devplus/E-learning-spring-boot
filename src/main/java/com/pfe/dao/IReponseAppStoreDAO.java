package com.pfe.dao;

import java.util.List;

import com.pfe.entity.ReponseApp;

public interface IReponseAppStoreDAO {
	
	List<ReponseApp> getReponseApps();
	ReponseApp getReponseApp(int ReponseAppAppId);
	ReponseApp createReponseApp(ReponseApp ReponseApp);
	ReponseApp updateReponseApp(int ReponseAppAppId,ReponseApp ReponseAppApp);
	boolean deleteReponseApp(int ReponseAppAppId);

}
