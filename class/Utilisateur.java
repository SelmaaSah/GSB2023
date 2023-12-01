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
    private Date dateNaiss;
    private String mail;
    private String login;
    private String mdp;

    // Les Constructeurs

    /**
     * Constructeur par défaut de la classe Utilisateur.
     */
    public Utilisateur() {
    }

    /**
     * Constructeur avec tous les paramètres de la classe Utilisateur.
     * @param id Identifiant de l'utilisateur.
     * @param unNom Nom de l'utilisateur.
     * @param unPrenom Prénom de l'utilisateur.
     * @param uneDateNaiss Date de naissance de l'utilisateur.
     * @param leMail Adresse e-mail de l'utilisateur.
     * @param unLogin Identifiant de connexion de l'utilisateur.
     * @param leMdp Mot de passe de l'utilisateur.
     */
    public Utilisateur(int id, String unNom, String unPrenom, Date uneDateNaiss, String leMail, String unLogin, String leMdp) {
        this.idUser = id;
        this.nom = unNom;
        this.prenom = unPrenom;
        this.dateNaiss = uneDateNaiss;
        this.mail = leMail;
        this.login = unLogin;
        this.mdp = leMdp;
    }

    /**
     * Constructeur avec certains paramètres de la classe Utilisateur.
     * @param id Identifiant de l'utilisateur.
     * @param unNom Nom de l'utilisateur.
     * @param unPrenom Prénom de l'utilisateur.
     * @param leMail Adresse e-mail de l'utilisateur.
     */
    public Utilisateur(int id, String unNom, String unPrenom, String leMail) {
        this.idUser = id;
        this.nom = unNom;
        this.prenom = unPrenom;
        this.mail = leMail;
    }

    /**
     * Constructeur avec certains paramètres de la classe Utilisateur.
     * @param id Identifiant de l'utilisateur.
     * @param unNom Nom de l'utilisateur.
     * @param unPrenom Prénom de l'utilisateur.
     * @param unLogin Identifiant de connexion de l'utilisateur.
     * @param leMdp Mot de passe de l'utilisateur.
     */
    public Utilisateur(int id, String unNom, String unPrenom, String unLogin, String leMdp) {
        this.idUser = id;
        this.nom = unNom;
        this.prenom = unPrenom;
        this.login = unLogin;
        this.mdp = leMdp;
    }

    /**
     * Constructeur avec certains paramètres de la classe Utilisateur.
     * @param unNom Nom de l'utilisateur.
     * @param unPrenom Prénom de l'utilisateur.
     */
    public Utilisateur(String unNom, String unPrenom) {
        this.nom = unNom;
        this.prenom = unPrenom;
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
     * Obtient la date de naissance de l'utilisateur.
     * @return La date de naissance de l'utilisateur.
     */
    public Date getDateNaiss() {
        return dateNaiss;
    }

    /**
     * Modifie la date de naissance de l'utilisateur.
     * @param dateNaiss La nouvelle date de naissance de l'utilisateur.
     */
    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    /**
     * Obtient l'adresse e-mail de l'utilisateur.
     * @return L'adresse e-mail de l'utilisateur.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Modifie l'adresse e-mail de l'utilisateur.
     * @param mail La nouvelle adresse e-mail de l'utilisateur.
     */
    public void setMail(String mail) {
        this.mail = mail;
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