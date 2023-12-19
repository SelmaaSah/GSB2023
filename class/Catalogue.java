import java.sql.Date;

public class Catalogue {

	//Les attributs 
	private int idCatalogue;
	private Date dateP;
	private int dureePrevue;
	private int sallenum;
	private int heure;
	private String animateurNom;
	
	public Catalogue() {
		
	}

	public Catalogue(int lIdCattalogue,Date dateP, int dureePrevue, int sallenum,  String leNomAnimateur) {
		this.idCatalogue = lIdCattalogue;
		this.dateP = dateP;
		this.dureePrevue = dureePrevue;
		this.sallenum = sallenum;
		this.animateurNom = leNomAnimateur;
	}
	
	
	public Date getDateP() {
		return dateP;
	}

	public int getIdCatalogue() {
		return idCatalogue;
	}

	public int getDureePrevue() {
		return dureePrevue;
	}

	

	public int getSallenum() {
		return sallenum;
	}


	public int getHeure() {
		return heure;
	}


	public String getAnimateurNom() {
		return animateurNom;
	}

	
	
}
