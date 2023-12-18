
public class Salle {
	private int idSalle;
	private String nomSalle;
	
	public Salle(){
		
	}
	
	public Salle(int lIdSalle, String leNomSalle) {
		this.idSalle = lIdSalle;
		this.nomSalle = leNomSalle;
	}

	public int getIdSalle() {
		return idSalle;
	}


	public String getNomSalle() {
		return nomSalle;
	}

	
}
