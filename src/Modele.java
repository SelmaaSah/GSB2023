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
	         
	            resultat = "Connexion r�ussie � la BDD";
	        } catch (ClassNotFoundException erreur) {
	            resultat = "Driver non charg� !" + erreur;
	        } catch (SQLException erreur) {
	            resultat = "La connexion � la base de donn�es a �chou�" + erreur + "<br>";
	        }
	        return resultat;
	 }
	 
	// M�thode pour la d�connexion � la BDD
	    public static void deconnexionBDD() {
	        try {
	            conn.close();
	        } catch (SQLException erreur) {
	            System.out.println("La d�connexion � la base de donn�es a �chou�" + erreur);
	        }
	    }
}
