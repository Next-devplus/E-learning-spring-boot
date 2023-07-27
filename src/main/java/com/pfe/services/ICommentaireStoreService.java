package com.pfe.services;

import java.util.List;

import com.pfe.entity.Commentaire;

public interface ICommentaireStoreService {
	
	List<Commentaire> getCommentaires();
	Commentaire createCommentaire(Commentaire Commentaire);
	Commentaire updateCommentaire(int CommentaireId, Commentaire Commentaire);
	Commentaire getCommentaire(int CommentaireId);
	boolean deleteCommentaire(int CommentaireId);

}
