

public class Animateur {

    private String idAnimateur;
    private String nomAnimateur;
    private String prenomAnimateur;

    public Animateur() {
    }

    public Animateur(String lIdAnimateur, String leNomAnimateur, String lePrenomAnimateur) {
        this.idAnimateur = lIdAnimateur;
        this.nomAnimateur = leNomAnimateur;
        this.prenomAnimateur = lePrenomAnimateur;
    }

    public Animateur(String lIdAnimateur, String leNomAnimateur) {
        this.idAnimateur = lIdAnimateur;
        this.nomAnimateur = leNomAnimateur;
    }

    public String getIdAnimateur() {
        return this.idAnimateur;
    }

    public String getNomAnimateur() {
        return this.nomAnimateur;
    }

    public String getPrenomAnimateur() {
        return this.prenomAnimateur;
    }

    @Override
    public String toString() {
        return nomAnimateur;
    }
    
    public String toCSVString() {
    	String res = this.idAnimateur + " ; " +  this.nomAnimateur + " ; " + this.prenomAnimateur;
    	return res;
    }
    
    public String toXMLString() {
    	String res = "&nbsp; &lt id> " + this.idAnimateur + "&lt /id> <br>"
    			+ "&nbsp; &lt Nom Animateur>" + this.nomAnimateur + "&lt /Nom Animateur> <br>"
    			+ "&nbsp; &lt Prenom Animateur>" + this.prenomAnimateur + "&lt /Prenom Animateur> <br>"
    			;
    	return res;
    }
    
    public String toJSONString() {
    	String res = "{<br>"
    			+ "&nbsp; \"id \": " + this.idAnimateur + ",<br>"
    			+ "&nbsp; \"Nom Animateur \": " + this.nomAnimateur + "\",<br>"
    			+ "&nbsp; \"Prenom ANimateur\": " + this.prenomAnimateur + "\",<br>"
    			+ "}"
    			;
    	return res;
    }
    
}
