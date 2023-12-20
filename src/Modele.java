import java.sql.Connection;
import java.sql.Date;
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
	
	/**
	 * Notre focntion d'insertion de conference
	 * @param theme
	 * @param dateDeroulement
	 * @param idAnimateur
	 */
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
	 * Cette fonction nous permet d'inserer une nouvelle presentation
	 * @param datePrevue
	 * @param dureePrevue
	 * @param salleid
	 * @param heure
	 * @param animateurId
	 */
    public static void insererNvPresentation(String datePrevue,int dureePrevue, int salleid, int heure,int animateurId) {
    	connexionBDD();
    	
        try {
            // Requête d'insertion
            String req = "INSERT INTO presentation (dateP, dureePrevue, sallenum,heure,animateurid) VALUES (?, ?, ?, ?, ?)";
            preparedSt = Modele.conn.prepareStatement(req);
            preparedSt.setString(1, datePrevue);
            preparedSt.setInt(2, dureePrevue);
            preparedSt.setInt(3, salleid);
            preparedSt.setInt(4, heure);
            preparedSt.setInt(5, animateurId);

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
    
    public static void insertNvUtilisateur(String nom, String prenom, String login, String mdp, String typeUtilisateur ) {
    	connexionBDD();
    	
        try {
            // Requête d'insertion
            String req = "INSERT INTO utilisateur (nom, prenom, login, mdp, typeVisiteur) VALUES (?, ?, ?, ?, ?)";
            preparedSt = conn.prepareStatement(req);
            preparedSt.setString(1, nom);
            preparedSt.setString(2, prenom);
            preparedSt.setString(3, login);
            preparedSt.setString(4, mdp);
            preparedSt.setString(5, typeUtilisateur);

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
    
    
 
    
    public static ArrayList<Catalogue> getLesCatalogues() {
        connexionBDD();

        ArrayList<Catalogue> lesCatalogues = new ArrayList<Catalogue>();
        int id,dureePrevue, sallenum;
        Date dateP;
        

        Catalogue catalogue;

        String animateurNom, req = "SELECT P.id, dateP, dureePrevue, sallenum,  U.nom "
        		+ "FROM presentation P,animateur A,utilisateur U "
        		+ "WHERE A.id = P.animateurid "
        		+ "AND U.id = A.userid "
        		+ "ORDER BY P.id ;";

        try {
            res = st.executeQuery(req);
            while (res.next()) {

            	id = res.getInt(1);
            	dateP = res.getDate(2);
            	dureePrevue = res.getInt(3);
            	sallenum = res.getInt(4);
            	animateurNom = res.getString(5);

            	

            	catalogue = new Catalogue(id, dateP, dureePrevue, sallenum, animateurNom);
            	lesCatalogues.add(catalogue);
                
            }
            res.close();
            deconnexionBDD();
        } catch (SQLException erreur) {
            System.out.println("La requête getLesCatalogues échoue" + erreur);
        }
        return lesCatalogues;
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
	
	/**
	 * Cette finction nous permet de recuperer les Salles
	 * @return la liste des Salles avec le nom et l'id
	 */
	public static ArrayList<Salle> getLesSalles() {
		connexionBDD();
    	
    	ArrayList<Salle> lesSalles = new ArrayList<Salle>();
    	
    	Salle salle;
    	
    	int id;
		String nom,req = "SELECT * "
				+ "FROM salle";
    	
    	try {
    		res = st.executeQuery(req);
    		while (res.next()) {
    			id = res.getInt(1);
    			nom = res.getString(2);
    			
    			salle = new Salle(id, nom);
    			lesSalles.add(salle);
    		}
    		res.close();
            deconnexionBDD();
    	}
    	catch (SQLException erreur) {
    		System.out.println("La requête à échoue" + erreur);
    	}
    	
    	return lesSalles;
	}
	
	
	/**
	 * Cette finction nous permet de recuperer les Salles
	 * @return la liste des Salles avec le nom et l'id
	 */
	public static ArrayList<User> getLesUsers() {
		connexionBDD();
    	
    	ArrayList<User> lesUsers = new ArrayList<User>();
    	
    	User user;
    	
    	int id;
		String nom, prenom, login, mdp, typeVisiteur ,req = "SELECT * "
															+ "FROM utilisateur "
															+ "WHERE typeVisiteur = 'Animateur' "
															+ "OR typeVisiteur = 'Intervenant' ";
    	
    	try {
    		res = st.executeQuery(req);
    		while (res.next()) {
    			id = res.getInt(1);
    			nom = res.getString(2);
    			prenom = res.getString(3);
    			login = res.getString(4);
    			mdp = res.getString(5);
    			typeVisiteur = res.getString(6);

    			user = new User( id,nom, prenom, login, mdp, typeVisiteur);
    			lesUsers.add(user);
    		}
    		res.close();
            deconnexionBDD();
    	}
    	catch (SQLException erreur) {
    		System.out.println("La requête à échoue" + erreur);
    	}
    	
    	return lesUsers;
	}

	public static boolean getSupprimerUnUtilisateur(int id) {
    	connexionBDD();
    	boolean rep = false;
    	String req = "DELETE FROM utilisateur "
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
	
	public static ArrayList<Presentation> getDatePresentation() {
		connexionBDD();
    	
		ArrayList<Presentation> datePresentation = new ArrayList<Presentation>();
    	
		Presentation presentation;
    	
//    	Date dateP;
		String dateP, nomP, req = "SELECT DISTINCT MONTH(dateP) AS mois, MONTHNAME(dateP) AS nom_mois "
				+ "FROM presentation "
				+ "ORDER BY dateP;";
    	
    	try {
    		res = st.executeQuery(req);
    		while (res.next()) {
    			
    			dateP = res.getString(1);
    			nomP = res.getString(2);
    			
    			presentation = new Presentation(dateP,nomP);
    			datePresentation.add(presentation);
    		}
    		res.close();
            deconnexionBDD();
    	}
    	catch (SQLException erreur) {
    		System.out.println("La requête à échoue" + erreur);
    	}
    	
    	return datePresentation;
	}
	
	public static ArrayList<Presentation> getPresentationAvecDate(String date) {
		connexionBDD();
    	
		ArrayList<Presentation> lesPresentation = new ArrayList<Presentation>();
    	
		Presentation presentation;

		int id,dureePresentation,salleNum,heure;
		String dateP, animateurPresentation, req = "SELECT P.id,dateP, dureePrevue,sallenum,heure,U.nom "
				+ "FROM presentation P,animateur A, utilisateur U "
				+ "WHERE A.id = P.animateurid "
				+ "AND U.id = A.userid "
				+ "AND MONTH(dateP)= ? "
				+ "ORDER BY dateP;";
    	
		try {
		    preparedSt = conn.prepareStatement(req);
		    preparedSt.setString(1, date);
		    
		    res = preparedSt.executeQuery();  // Utiliser la déclaration préparée, pas st.executeQuery(req)
		    
		    while (res.next()) {
		        // Traitement des résultats ici
		        id = res.getInt(1);
		        dateP = res.getString(2);
		        dureePresentation = res.getInt(3);
		        salleNum = res.getInt(4);
		        heure = res.getInt(5);
		        animateurPresentation = res.getString(6);

		        presentation = new Presentation(id, dateP, dureePresentation, salleNum, heure, animateurPresentation);
		        lesPresentation.add(presentation);
		    }

		    res.close();
		    deconnexionBDD();
		    
		} catch (SQLException erreur) {
		    System.out.println("La requête a échoué" + erreur);
		}

    	
    	return lesPresentation;
	}
	
	public static ArrayList<Conference> getDateConference() {
		connexionBDD();
    	
		ArrayList<Conference> dateConference = new ArrayList<Conference>();
    	
		Conference conference;
    	
//    	Date dateP;
		String dateP, nomP, req = "SELECT DISTINCT MONTH(daterouler) AS mois, MONTHNAME(daterouler) AS nom_mois  "
				+ "FROM conference "
				+ "ORDER BY daterouler;";
    	
    	try {
    		res = st.executeQuery(req);
    		while (res.next()) {
    			
    			dateP = res.getString(1);
    			nomP = res.getString(2);
    			
    			conference = new Conference(dateP,nomP);
    			dateConference.add(conference);
    		}
    		res.close();
            deconnexionBDD();
    	}
    	catch (SQLException erreur) {
    		System.out.println("La requête à échoue" + erreur);
    	}
    	
    	return dateConference;
	}
	    
}