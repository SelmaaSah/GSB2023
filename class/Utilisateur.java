import java.sql.Date;

/**
 * La classe Utilisateur représente un utilisateur du système avec ses attributs et méthodes associées.
 */
public class Utilisateur {

    // Attributs statiques partagés entre toutes les instances de la classe
    private static int idUser;

    // Les Attributs d'instance
    private String nom;
    private String prenom;
    private String typeVisiteur;
    private String login;
    private String mdp;

    // Les Constructeurs

    /**
     * Constructeur par défaut de la classe Utilisateur.
     */
    public Utilisateur() {
    }

    

    /**
     * Constructeur avec certains paramètres de la classe Utilisateur.
     * @param id Identifiant de l'utilisateur.
     * @param unNom Nom de l'utilisateur.
     * @param unPrenom Prénom de l'utilisateur.
     * @param leMail Adresse e-mail de l'utilisateur.
     */
    public Utilisateur(int id, String unNom, String unPrenom, String leTypeVisiteur) {
        this.idUser = id;
        this.nom = unNom;
        this.prenom = unPrenom;
        this.typeVisiteur = leTypeVisiteur;
    }

   

    // Les Accesseurs

    /**
     * Obtient l'identifiant de l'utilisateur.
     * @return L'identifiant de l'utilisateur.
     */
    public static int getIdUser() {
        return idUser;
    }

    /**
     * Modifie l'identifiant de l'utilisateur.
     * @param idUser Le nouvel identifiant de l'utilisateur.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Obtient le nom de l'utilisateur.
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de l'utilisateur.
     * @param nom Le nouveau nom de l'utilisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de l'utilisateur.
     * @return Le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom de l'utilisateur.
     * @param prenom Le nouveau prénom de l'utilisateur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  

    /**
     * Obtient l'identifiant de connexion de l'utilisateur.
     * @return L'identifiant de connexion de l'utilisateur.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Modifie l'identifiant de connexion de l'utilisateur.
     * @param login Le nouvel identifiant de connexion de l'utilisateur.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Obtient le mot de passe de l'utilisateur.
     * @return Le mot de passe de l'utilisateur.
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Modifie le mot de passe de l'utilisateur.
     * @param mdp Le nouveau mot de passe de l'utilisateur.
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}