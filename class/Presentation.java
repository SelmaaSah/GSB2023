import java.sql.Date;

public class Presentation {
	private int idPresentation;
	private String datePresentation;
	private String moisPresenttation;
	
	private int dureePresentation;
	private int sallePresentation;
	private int heurePresentation;
	private String animateur;
	
	public Presentation() {
		
	}
	public Presentation(String uneDatePresentation, String leMoisPresenttation) {
		this.datePresentation = uneDatePresentation;
		this.moisPresenttation = leMoisPresenttation;
	}
	
	public Presentation(int lIdPresentation, String uneDatePresentation,int laDureePresentation, int laSallePresentation,int lHeurePresentation,String lAnimateur) {
		this.idPresentation = lIdPresentation;
		this.datePresentation = uneDatePresentation;
		this.dureePresentation = laDureePresentation;
		this.sallePresentation = laSallePresentation;
		this.heurePresentation = lHeurePresentation;
		this.animateur = lAnimateur;
	}
	
	public String getDatePresentation() {
		return this.datePresentation;
	}
	
	public String getMoisPresenttation() {
		return moisPresenttation;
	}
	
	public int getIdPresentation() {
		return idPresentation;
	}
	
	public int getDureePresentation() {
		return dureePresentation;
	}
	
	public int getSallePresentation() {
		return sallePresentation;
	}
	
	public int getHeurePresentation() {
		return heurePresentation;
	}
	
	public String getAnimateur() {
		return animateur;
	}
	
	
	
}
