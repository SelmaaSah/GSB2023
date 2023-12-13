
public class Conference {

	
	//Les Attributs
	
	private int idC;
	private String theme;
	private String nomAnimateur;
	private String dateDeroulement;
	
	public Conference() {
	}
	
	




	

	public Conference(int idC, String theme, String nomAnimateur, String dateDeroulement) {
		super();
		this.idC = idC;
		this.theme = theme;
		this.nomAnimateur = nomAnimateur;
		this.dateDeroulement = dateDeroulement;
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
	
	public void setDateDeroulement(String dateDeroulement) {
		this.dateDeroulement = dateDeroulement;
		
		
	}
	
	
}
