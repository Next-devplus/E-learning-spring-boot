package com.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.dao.ICommentaireStoreDAO;
import com.pfe.entity.Commentaire;
 

@Service
public class CommentaireStoreService implements ICommentaireStoreService {
	
	@Autowired
	private ICommentaireStoreDAO dao;

	@Override
	public List<Commentaire> getCommentaires() {
		return dao.getCommentaires();
	}


	@Override
	public Commentaire createCommentaire(Commentaire Commentaire) {
		return dao.createCommentaire(Commentaire);
	}

	@Override
	public Commentaire updateCommentaire(int CommentaireId, Commentaire Commentaire) {
		return dao.updateCommentaire(CommentaireId, Commentaire);
	}

	@Override
	public Commentaire getCommentaire(int CommentaireId) {
		return dao.getCommentaire(CommentaireId);
	}

	@Override
	public boolean deleteCommentaire(int CommentaireId) {
		return dao.deleteCommentaire(CommentaireId);
	}

}
