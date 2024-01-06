package fr.insa.Avis.model;

public class AvisSuperUser {
	private String utilisateur;
	private int note;
	private String commentaire;

	public AvisSuperUser(String utilisateur, int note, String commentaire) {
		this.utilisateur = utilisateur;
		this.note = note;
		this.commentaire = commentaire;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}

