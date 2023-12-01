import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {
	private static Connection conn;
	private static Statement st;
	private static ResultSet res;
	private static PreparedStatement preparedSt;
	private static String resultat;
	
	public Modele() {
		
	}
	
	 public static String connexionBDD() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://172.16.203.201/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
	            st = conn.createStatement();
	         
	            resultat = "Connexion réussie à la BDD";
	        } catch (ClassNotFoundException erreur) {
	            resultat = "Driver non chargé !" + erreur;
	        } catch (SQLException erreur) {
	            resultat = "La connexion à la base de données a échoué" + erreur + "<br>";
	        }
	        return resultat;
	 }
	 
	// Méthode pour vérifier l'existence de l'utilisateur dans la base de données
	    public static Utilisateur existeUser(String identifiant, String mdp) {
	        connexionBDD();
	        Utilisateur utilisateur = null;

	        String req = "SELECT COUNT(*), idUser, nom, prenom, dateNais, email "
	                + "FROM UTILISATEUR "
	                + "WHERE loginU = ? "
	                + "AND mdp = md5(?) ;";

	        try {
	            preparedSt = conn.prepareStatement(req);
	            preparedSt.setString(1, identifiant);
	            preparedSt.setString(2, mdp);
	            
//	            System.out.println(sha1(mdp));

	            res = preparedSt.executeQuery();

	            if (res.next()) {
	                int count = res.getInt(1);
	                if (count == 1) {
	                    int id = res.getInt("idUser");
	                    String nom = res.getString("nom");
	                    String prenom = res.getString("prenom");
	                    String email = res.getString("email");

	                    utilisateur = new Utilisateur(id, nom, prenom, email);
	                }
	            }

	            res.close();

	        } catch (SQLException erreur) {
	            System.out.println("La requête a échoué " + erreur);
	        }
	        deconnexionBDD();

	        return utilisateur;
	    }
	 
	// Méthode pour la déconnexion à la BDD
	    public static void deconnexionBDD() {
	        try {
	            conn.close();
	        } catch (SQLException erreur) {
	            System.out.println("La déconnexion à la base de données a échoué" + erreur);
	        }
	    }
}
