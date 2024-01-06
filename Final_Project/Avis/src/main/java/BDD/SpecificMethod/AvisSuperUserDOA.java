package BDD.SpecificMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.insa.Avis.model.AvisSuperUser;

public class AvisSuperUserDOA {

    public AvisSuperUserDOA(DatabaseAccess databaseAccess) {
    }

    public static void createAvisSuperUser(AvisSuperUser AvisSuperUser){
        String query = "INSERT INTO SuperUser (utilisateur, note, commentaire) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, AvisSuperUser.getUtilisateur());
            preparedStatement.setInt(2, AvisSuperUser.getNote());
            preparedStatement.setString(3, AvisSuperUser.getCommentaire());
            preparedStatement.executeUpdate();
            System.out.println("SuperUser ajouté avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static AvisSuperUser getAvisSuperUser(String utilisateur) {
        String query = "SELECT * FROM SuperUser WHERE utilisateur = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, utilisateur);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AvisSuperUser(resultSet.getString("utilisateur"), resultSet.getInt("note"), resultSet.getString("commentaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateSuperUserCommentaire(String commentaire, String utilisateur) {
        String query = "UPDATE SuperUser SET commentaire = ? WHERE utilisateur = ?";
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, commentaire);
            preparedStatement.setString(2, utilisateur);
            preparedStatement.executeUpdate();
            System.out.println("Commentaire SuperUser modifié avec succès.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<AvisSuperUser> getAllSuperUsers() {
        String query = "SELECT * FROM SuperUser";
        List<AvisSuperUser> allSuperUsers = new ArrayList<>();  // Declare the list outside the try block
        
        try (PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allSuperUsers.add(new AvisSuperUser(
                    resultSet.getString("utilisateur"), 
                    resultSet.getInt("note"), 
                    resultSet.getString("commentaire")
                ));
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return allSuperUsers;  
    }


         
       
         
}

