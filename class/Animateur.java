
public class Animateur {

	private String idAnimateur;
	private String nomAnimateur;
	private String prenomAnimateur;
	
	public Animateur() {
	}
	
	public Animateur(String lIdAnimateur, String leNomAnimateur,String lePrenomAnimateur) {
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
	
	public String getNomAnimateur(){
		return this.nomAnimateur;
	}
	
	public String getPrenomAnimateur() {
		return this.prenomAnimateur;
	}
	
	@Override
    public String toString() {
        return nomAnimateur;
    }
}
