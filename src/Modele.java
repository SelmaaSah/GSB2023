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
	
	
	/**
	 * Établit une connexion à la base de données.
	 * @return Un message indiquant le résultat de la tentative de connexion :
	 *         - "Connexion réussie à la BDD" en cas de succès.
	 *         - "Driver non chargé !" avec la description de l'erreur en cas d'échec du chargement du pilote.
	 *         - "La connexion à la base de données a échoué" suivi de la description de l'erreur en cas d'échec de la connexion.
	 */
//	La connexion avec la BDD 
	public static String connexionBDD() {
	        try {
	        	 // Charger le pilote JDBC MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Établir la connexion à la base de données avec les informations de connexion
	            conn = DriverManager.getConnection("jdbc:mysql://172.16.203.201/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
//	            conn = DriverManager.getConnection("jdbc:mysql://localhost/GSB2?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");

	            st = conn.createStatement();
	         
	         // Message de succès
	            resultat = "Connexion reussie � la BDD";
	        } catch (ClassNotFoundException erreur) {
	            resultat = "Driver non charge !" + erreur;
	        } catch (SQLException erreur) {
	            resultat = "La connexion a la base de donnees a echoue" + erreur + "<br>";
	        }
	        return resultat;
	 }
	 
	
	/**
	 * Vérifie l'existence d'un utilisateur dans la bdd en utilisant
	 * l'identifiant (login) et le mot de passe fournis.
	 *
	 * @param identifiant Identifiant (login) de l'utilisateur à vérifier.
	 * @param mdp Mot de passe de l'utilisateur à vérifier.
	 * @return Un objet Utilisateur représentant l'utilisateur s'il existe dans la base de données,
	 *         sinon retourne null.
	 */
	// M�thode pour v�rifier l'existence de l'utilisateur dans la base de donn�es
	public static Utilisateur existeUser(String identifiant, String mdp) {
		connexionBDD();
		Utilisateur utilisateur = null;

		
		//requete sql 
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
            // Préparer la requête SQL avec les paramètres

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
            // Gérer les erreurs liées à l'insertion

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
	
    
    /**
     * Insère une nouvelle conférence dans la base de données avec les informations fournies.
     *
     * @param dateP La date de la conférence.
     * @param dureePrevue La durée prévue de la conférence en minutes.
     * @param sallenum Le numéro de la salle où se tiendra la conférence.
     * @param heure L'heure de début de la conférence.
     * @param animateurid L'identifiant de l'animateur associé à la conférence.
     */
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
    
    
    /**
     * Récupère la liste des catalogues de présentations depuis la base de données.
     *
     * @return Une ArrayList d'objets Catalogue représentant les catalogues de présentations disponibles.
     */
    
    public static ArrayList<Catalogue> getLesCatalogues() {
        connexionBDD();

        ArrayList<Catalogue> lesCatalogues = new ArrayList<Catalogue>();
        int id,dureePrevue, sallenum;
       
        

        Catalogue catalogue;

        String animateurNom, dateP,req = "SELECT P.id, dateP, dureePrevue, sallenum,  U.nom "
        		+ "FROM presentation P,animateur A,utilisateur U "
        		+ "WHERE A.id = P.animateurid "
        		+ "AND U.id = A.userid "
        		+ "ORDER BY P.id ;";

        try {
            res = st.executeQuery(req);
            while (res.next()) {

            	id = res.getInt(1);
            	dateP = res.getString(2);
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
    
    
    
    /**
     * Supprime une conférence en utilisant son identifiant.
     *
     * @param id L'identifiant de la conférence à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    
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
	 * Récupère la liste des utilisateurs ayant le rôle "Animateur" ou "Intervenant"
	 * depuis la base de données.
	 *
	 * @return Une ArrayList d'objets User
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
	
	
	
	public static ArrayList<User> getLesUsers2() {
		connexionBDD();
    	
    	ArrayList<User> lesUsers = new ArrayList<User>();
    	
    	User user;
    	
    	int id;
		String nom, prenom, login, mdp, typeVisiteur ,req = "SELECT * "
															+ "FROM utilisateur "
															+ "WHERE typeVisiteur = 'Secretaire' ";
															
    	
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
	
	/**
	 * Récupère le mois 
	 * depuis la base de données.
	 *
	 * @return Une ArrayList d'objets User
	 */
	
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
	
	public static ArrayList<Conference> getConferenceAvecDate(String date) {
		connexionBDD();
    	
		ArrayList<Conference> lesConference = new ArrayList<Conference>();
    	
		Conference conference;

		int id;
		String theme, dateDerouler,nom, req = "SELECT C.id, C.theme, C.daterouler, U.nom "
				+ "FROM conference C, animateur A, utilisateur U "
				+ "WHERE A.id = C.animateurid "
				+ "AND U.id = A.userid "
				+ "AND MONTH(daterouler)= ? "
				+ "ORDER BY daterouler;";
    	
		try {
		    preparedSt = conn.prepareStatement(req);
		    preparedSt.setString(1, date);
		    
		    res = preparedSt.executeQuery();  // Utiliser la déclaration préparée, pas st.executeQuery(req)
		    
		    while (res.next()) {
		        // Traitement des résultats ici
		        id = res.getInt(1);
		        theme = res.getString(2);
		        dateDerouler = res.getString(3);
		        nom = res.getString(4);

		        conference = new Conference(id, theme, dateDerouler, nom);
		        lesConference.add(conference);
		    }

		    res.close();
		    deconnexionBDD();
		    
		} catch (SQLException erreur) {
		    System.out.println("La requête a échoué" + erreur);
		}

    	
    	return lesConference;
	}
	
	
	/**
	 * Insère un nouveau secrétaire dans la bdd via le formulaire avec les informations fournies.
	 *
	 * @param nomS Le nom du nouveau secrétaire.
	 * @param prenomS Le prénom du nouveau secrétaire.
	 * @param loginS Le nom d'utilisateur (login) du nouveau secrétaire.
	 * @param mdpS Le mot de passe du nouveau secrétaire.
	 */
    public static void insertNvSecretaire(String nomS, String prenomS, String loginS, String mdpS) {
    	connexionBDD();
    	
        try {
            // Requête d'insertion
            String req = "INSERT INTO utilisateur (nom, prenom, login, mdp, typeVisiteur) VALUES (?, ?, ?,?, 'Secretaire')";
            preparedSt = conn.prepareStatement(req);
            preparedSt.setString(1, nomS);
            preparedSt.setString(2, prenomS);
            preparedSt.setString(3, loginS);
            preparedSt.setString(4, mdpS);

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
    
    
    
    
	
	
	
	
	
	
	
	
	
	
}