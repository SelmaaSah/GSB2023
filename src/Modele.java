import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modele {
	private static Connection conn;
	private static Statement st;
	private static ResultSet res;
	private static PreparedStatement preparedSt;
	private static String resultat;
	
	public Modele() {
		
	}
	
//	La connexion avec la BDD 
	public static String connexionBDD() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://172.16.203.201/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
//	            conn = DriverManager.getConnection("jdbc:mysql://localhost/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
	            st = conn.createStatement();
	         
	            resultat = "Connexion r�ussie � la BDD";
	        } catch (ClassNotFoundException erreur) {
	            resultat = "Driver non charg� !" + erreur;
	        } catch (SQLException erreur) {
	            resultat = "La connexion � la base de donn�es a �chou�" + erreur + "<br>";
	        }
	        return resultat;
	 }
	 
	// M�thode pour v�rifier l'existence de l'utilisateur dans la base de donn�es
	public static Utilisateur existeUser(String identifiant, String mdp) {
		connexionBDD();
		Utilisateur utilisateur = null;

		String req = "SELECT COUNT(*),id,nom,prenom,typeVisiteur "
				+ "FROM utilisateur "
				+ "WHERE login = ? "
				+ "AND mdp = ?;";

		try {
			preparedSt = conn.prepareStatement(req);
			preparedSt.setString(1, identifiant);
			preparedSt.setString(2, mdp);
			
	            

			res = preparedSt.executeQuery();

			if (res.next()) {
				int count = res.getInt(1);
				if (count == 1) {
					
					int id = res.getInt("id");
					String nom = res.getString("nom");
					String prenom = res.getString("prenom");
					String typeVisiteur = res.getString("typeVisiteur");

					utilisateur = new Utilisateur(id, nom, prenom,typeVisiteur);
				}
			}

			res.close();

		} catch (SQLException erreur) {
			System.out.println("La requ�te a �chou� " + erreur);
		}
		deconnexionBDD();

		return utilisateur;
	 }
	 
	
	
	
	// M�thode pour la d�connexion � la BDD
	public static void deconnexionBDD() {
		try {
			conn.close();
		} catch (SQLException erreur) {
			System.out.println("La d�connexion � la base de donn�es a �chou�" + erreur);
		}
	}
	
	
    public void insererNvConference(int idC, String theme, String nomAnimateur, String dateDeroulement) {
        try {
            // Requête d'insertion
            String req = "INSERT INTO conference (id, theme, daterouler, animateurid) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = Modele.conn.prepareStatement(req);
            preparedStatement.setInt(1, idC);
            preparedStatement.setString(2, theme);
            preparedStatement.setString(3, nomAnimateur);
            preparedStatement.setString(4, dateDeroulement);

            // Exécuter la requête d'insertion
            preparedStatement.executeUpdate();

            // Fermer le statement
            preparedStatement.close();

        } catch (SQLException erreur) {
            System.out.println("L'insertion a échoué " + erreur);
        }
    }
	
	
	
	/**
     * Récupère la liste des films depuis la base de données
     * @return Une liste de programmes représentant les films
     */
    public static ArrayList<Conference> getLesConferences() {
        connexionBDD();

        ArrayList<Conference> lesConferences = new ArrayList<Conference>();
        int idC;
        String theme, nomAnimateur, dateDeroulement;

        Conference conference;

        String req = "SELECT C.id, theme, daterouler, animateurid "
        		+ "FROM conference C, animateur A "
        		+ "WHERE A.id = C.id ";

        try {
            res = st.executeQuery(req);
            while (res.next()) {

            	idC = res.getInt(1);
            	theme = res.getString(2);
            	nomAnimateur = res.getString(3);
            	dateDeroulement = res.getString(4);

            	conference = new Conference(idC, theme, nomAnimateur, dateDeroulement);
                lesConferences.add(conference);
                
            }
            res.close();
        } catch (SQLException erreur) {
            System.out.println("La requête getLesFilms échoue" + erreur);
        }
        return lesConferences;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	    
}
