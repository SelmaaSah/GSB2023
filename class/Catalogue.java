import java.sql.Date;

public class Catalogue {

	//Les attributs 
	private int idCatalogue;
	private String dateP;
	private int dureePrevue;
	private int sallenum;
	private int heure;
	private String animateurNom;
	
	public Catalogue() {
		
	}

	public Catalogue(int lIdCattalogue,String dateP, int dureePrevue, int sallenum,  String leNomAnimateur) {
		this.idCatalogue = lIdCattalogue;
		this.dateP = dateP;
		this.dureePrevue = dureePrevue;
		this.sallenum = sallenum;
		this.animateurNom = leNomAnimateur;
	}
	
	public String getDateP() {
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
	
	public String toCSVString() {
		String res = this.idCatalogue + " ; " +  this.dateP + " ; " + this.dureePrevue + " ; " + this.sallenum + " ; " +  this.animateurNom + "<br>";
    	return res;
	}
	
	public String toXMlString() {
		String res = "&nbsp; &lt id> " + this.idCatalogue + "&lt /id> <br>"
    			+ "&nbsp; &lt Date>" + this.dateP + "&lt /Date> <br>"
    			+ "&nbsp; &lt Duree Prevue>" + this.dureePrevue + "&lt /Duree Prevue> <br>"
    			+ "&nbsp; &lt Numero Salle>" + this.sallenum + "&lt /Numero Salle> <br>"
    			+ "&nbsp; &lt Nom Animateur>" + this.animateurNom + "&lt /Nom Animateur> <br>"
    			;
    	return res;
	}
	
	public String toJSONString() {
    	String res = "{<br>"
    			+ "&nbsp; \"id \": " + this.idCatalogue + ",<br>"
    			+ "&nbsp; \"Date \": " + this.dateP + "\",<br>"
    			+ "&nbsp; \"Duree Prevue\": " + this.dureePrevue + "\",<br>"
    			+ "&nbsp; \"Numero Salle\": " + this.sallenum + "\",<br>"
    			+ "&nbsp; \"Numero Salle\": " + this.animateurNom + "\",<br>"
    			+ "}"
    			;
    	return res;
    }
	
}
