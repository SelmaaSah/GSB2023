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
	 
	// Méthode pour la déconnexion à la BDD
	    public static void deconnexionBDD() {
	        try {
	            conn.close();
	        } catch (SQLException erreur) {
	            System.out.println("La déconnexion à la base de données a échoué" + erreur);
	        }
	    }
}
