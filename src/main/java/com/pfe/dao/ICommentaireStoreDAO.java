package com.pfe.dao;

import java.util.List;

import com.pfe.entity.Commentaire;

public interface ICommentaireStoreDAO {
	
	List<Commentaire> getCommentaires();
	Commentaire getCommentaire(int CommentaireId);
	Commentaire createCommentaire(Commentaire Commentaire);
	Commentaire updateCommentaire(int CommentaireId,Commentaire Commentaire);
	boolean deleteCommentaire(int CommentaireId);

}
