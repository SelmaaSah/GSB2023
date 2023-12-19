
public class User {

	private int idUser;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String typeVisiteur;
	
	public User() {
		
	}
	
	
	public User(int lIdUser, String nom, String prenom, String login, String mdp, String typeVisiteur) {
		this.idUser = lIdUser;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.typeVisiteur = typeVisiteur;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}

	
	public String getLogin() {
		return login;
	}


	public String getMdp() {
		return mdp;
	}


	public String getTypeVisiteur() {
		return typeVisiteur;
	}

	
}
