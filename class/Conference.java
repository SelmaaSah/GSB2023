
public class Conference {

	
	//Les Attributs
	
	private int idC;
	private String theme;
	private String dateDeroulement;
	private String nomAnimateur;
	
	
	public Conference() {
	}
	
	public Conference(String laDate, String leNomAnimateur) {
		this.dateDeroulement = laDate;
		this.nomAnimateur = leNomAnimateur;
	}

	public Conference(int idC, String theme, String dateDeroulement, String nomAnimateur) {
		this.idC = idC;
		this.theme = theme;
		this.dateDeroulement = dateDeroulement;
		this.nomAnimateur = nomAnimateur;
	}

	public int getIdC() {
		return idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public String getNomAnimateur() {
		return nomAnimateur;
	}
	
	public void setNomAnimateur(String nomAnimateur) {
		this.nomAnimateur = nomAnimateur;
	}
	
	public String getDateDeroulement() {
		return dateDeroulement;
	}
	
	public String toCSVString() {
		String res = this.idC + " ; " +  this.theme + " ; " + this.nomAnimateur + " ; " + this.dateDeroulement ;
    	return res;
	}
	
	public String toXMlString() {
		String res = "&nbsp; &lt id> " + this.idC + "&lt /id> <br>"
    			+ "&nbsp; &lt Theme>" + this.theme + "&lt /Theme> <br>"
    			+ "&nbsp; &lt Nom Animateur>" + this.nomAnimateur + "&lt /Nom Animateur> <br>"
    			+ "&nbsp; &lt Date du deroulement>" + this.dateDeroulement + "&lt /Date du deroulement> <br>"
    			;
    	return res;
	}
	
	public String toJSONString() {
    	String res = "{<br>"
    			+ "&nbsp; \"id \": " + this.idC + ",<br>"
    			+ "&nbsp; \"Theme \": " + this.theme + "\",<br>"
    			+ "&nbsp; \"Nom Animateur\": " + this.nomAnimateur + "\",<br>"
    			+ "&nbsp; \"Date du deroulement\": " + this.dateDeroulement + "\",<br>"
    			+ "}"
    			;
    	return res;
    }
	
	
}
