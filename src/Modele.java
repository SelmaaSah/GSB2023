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
//	            conn = DriverManager.getConnection("jdbc:mysql://172.16.203.201/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
	            st = conn.createStatement();
	         
	            resultat = "Connexion reussie � la BDD";
	        } catch (ClassNotFoundException erreur) {
	            resultat = "Driver non charge !" + erreur;
	        } catch (SQLException erreur) {
	            resultat = "La connexion a la base de donnees a echoue" + erreur + "<br>";
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
	
	
    public static void insererNvConference(String theme, String dateDeroulement, int idAnimateur ) {
    	connexionBDD();
    	
        try {
            // Requête d'insertion
            String req = "INSERT INTO conference (theme, daterouler, animateurid) VALUES (?, ?, ?)";
            preparedSt = Modele.conn.prepareStatement(req);
            preparedSt.setString(1, theme);
            preparedSt.setString(2, dateDeroulement);
            preparedSt.setInt(3, idAnimateur);

            // Exécuter la requête d'insertion
            preparedSt.executeUpdate();

            // Fermer le statement
            preparedSt.close();
            deconnexionBDD();
        } 
        catch (SQLException erreur) {
            System.out.println("L'insertion a échoué " + erreur);
        }
    }
	
	
	
	/**

     * Récupère la liste 
     * @return Une liste
     */
    public static ArrayList<Conference> getLesConferences() {
        connexionBDD();

        ArrayList<Conference> lesConferences = new ArrayList<Conference>();
        int idC;
        String theme, nomAnimateur, dateDeroulement;

        Conference conference;

        String req = "SELECT C.id, theme, daterouler, U.nom "
        		+ "FROM conference C,animateur A,utilisateur U "
        		+ "WHERE A.id = C.animateurid "
        		+ "AND U.id = A.userid "
        		+ "ORDER BY C.id ;";

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
            deconnexionBDD();
        } catch (SQLException erreur) {
            System.out.println("La requête getLesFilms échoue" + erreur);
        }
        return lesConferences;
    }
	
    /**
     * Récupere les Animateurs
     * @return une liste des Animateurs
     */
    public static ArrayList<Animateur> getLesAnimateur(){
    	connexionBDD();
    	
    	ArrayList<Animateur> lesAnimateurs = new ArrayList<Animateur>();
    	
    	Animateur animateur;
    	
    	String id;
		String nom,req = "SELECT animateur.id,nom "
				+ "FROM utilisateur, animateur "
				+ "WHERE utilisateur.id = animateur.userid "
				+ "AND typeVisiteur = 'Animateur'; ";
    	
    	try {
    		res = st.executeQuery(req);
    		while (res.next()) {
    			id = res.getString(1);
    			nom = res.getString(2);
    			
    			animateur = new Animateur(id, nom);
    			lesAnimateurs.add(animateur);
    		}
    		res.close();
            deconnexionBDD();
    	}
    	catch (SQLException erreur) {
    		System.out.println("La requête à échoue" + erreur);
    	}
    	
    	return lesAnimateurs;
    }
	
    
    
    public static void insertnvCatalogue(String dateP, int dureePrevue, int sallenum, int heure, int animateurid ) {
    	connexionBDD();
    	
        try {
            // Requête d'insertion
            String req = "INSERT INTO conference (dateP, dureePrevue, sallenum, heure, animateurid) VALUES (?, ?, ?, ?, ?)";
            preparedSt = Modele.conn.prepareStatement(req);
            preparedSt.setString(1, dateP);
            preparedSt.setInt(2, dureePrevue);
            preparedSt.setInt(3, sallenum);
            preparedSt.setInt(4, heure);
            preparedSt.setInt(5, animateurid);

            // Exécuter la requête d'insertion
            preparedSt.executeUpdate();

            // Fermer le statement
            preparedSt.close();
            deconnexionBDD();
        } 
        catch (SQLException erreur) {
            System.out.println("L'insertion a échoué " + erreur);
        }
        
    }
 
    public static boolean getSupprimerUneConference(int id) {
    	connexionBDD();
    	boolean rep = false;
    	String req = "DELETE FROM conference "
    			+ "WHERE id = ?";
    	
    	try {
    		preparedSt = conn.prepareStatement(req);
			preparedSt.setInt(1, id);
			
			preparedSt.executeUpdate();
			
				rep = true;
    		
    	} catch (SQLException erreur) {
			System.out.println("La requete a echoue " + erreur);
		}
    	return rep;
    }
	
	
	
	
	
	
	
	
	
	    
}