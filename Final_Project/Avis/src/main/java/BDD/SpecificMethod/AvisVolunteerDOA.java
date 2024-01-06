package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.Avis.model.AvisVolunteer;

public class AvisVolunteerDOA {

    public AvisVolunteerDOA(DatabaseAccess databaseAccess) {
    }

    public static void createAvisVolunteer(AvisVolunteer avisVolunteer){
        String query = "INSERT INTO Volunteer (utilisateur, note, commentaire) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, avisVolunteer.getVolunteerId());
            preparedStatement.setInt(2, avisVolunteer.getRating());
            preparedStatement.setString(3, avisVolunteer.getComment());
            preparedStatement.executeUpdate();
            System.out.println("Volunteer ajouté avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AvisVolunteer getAvisVolunteer(String utilisateur) {
        String query = "SELECT * FROM Volunteer WHERE utilisateur = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, utilisateur);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AvisVolunteer(
                		resultSet.getString("volunteerId"), 
                		resultSet.getString("missionId"), 
                		resultSet.getString("comment"),
                		resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateVolunteerCommentaire(String commentaire, String utilisateur) {
        String query = "UPDATE Volunteer SET commentaire = ? WHERE utilisateur = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, commentaire);
            preparedStatement.setString(2, utilisateur);
            preparedStatement.executeUpdate();
            System.out.println("Commentaire Volunteer modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<AvisVolunteer> getAllVolunteers() {
        String query = "SELECT * FROM Volunteer";
        List<AvisVolunteer> allVolunteers = new ArrayList<>();  // Declare the list outside the try block
        
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allVolunteers.add(new AvisVolunteer(
                		resultSet.getString("volunteerId"), 
                		resultSet.getString("missionId"), 
                		resultSet.getString("comment"),
                		resultSet.getInt("rating")));
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return allVolunteers;  
    }
}

