package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.Avis.model.AvisHelpSeeker;

public class AvisHelpSeekerDOA {

    public AvisHelpSeekerDOA(DatabaseAccess databaseAccess) {
    }

    public static void createAvisHelpSeeker(AvisHelpSeeker avisHelpSeeker){
        String query = "INSERT INTO AvisHelpSeeker (idAvisHelpSeeker, Rating, Comment) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, avisHelpSeeker.getHelpSeekerId());
            preparedStatement.setInt(2, avisHelpSeeker.getRating());
            preparedStatement.setString(3, avisHelpSeeker.getComment());
            preparedStatement.executeUpdate();
            System.out.println("AvisHelpSeeker ajoutée avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AvisHelpSeeker getAvisHelpSeeker(String id) {
        String query = "SELECT * FROM AvisHelpSeeker WHERE idAvisHelpSeeker = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AvisHelpSeeker(
                		resultSet.getString("missionId"),
                        resultSet.getString("helpSeekerId"),
                        resultSet.getString("comment"),
                        resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateAvisHelpSeekerRating(int rating, String id) {
        String query = "UPDATE AvisHelpSeeker SET Rating = ? WHERE idAvisHelpSeeker = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, rating);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("AvisHelpSeeker Rating modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<AvisHelpSeeker> getAllAvisHelpSeekers() {
        String query = "SELECT * FROM AvisHelpSeeker";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AvisHelpSeeker> allAvisHelpSeekers = new ArrayList<>();
            while (resultSet.next()) {
                allAvisHelpSeekers.add(new AvisHelpSeeker(
                        		resultSet.getString("missionId"),
                                resultSet.getString("helpSeekerId"),
                                resultSet.getString("comment"),
                                resultSet.getInt("rating")));
            }
            return allAvisHelpSeekers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
