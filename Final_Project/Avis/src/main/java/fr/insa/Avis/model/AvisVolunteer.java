package fr.insa.Avis.model;


public class AvisVolunteer {
	private String volunteerId;
	private String missionId;
	private String comment;
	private int rating;

	// Constructors, getters, and setters

	// Constructor
	public AvisVolunteer(String volunteerId, String missionId, String comment, int rating) {
		this.volunteerId = volunteerId;
		this.missionId = missionId;
		this.comment = comment;
		this.rating = rating;
	}

	// Getters and setters
	public String getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getMissionId() {
		return missionId;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
