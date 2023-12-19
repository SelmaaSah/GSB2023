import java.sql.Date;

public class Presentation {
	private String datePresentation;
	private String moisPresenttation;
	
	public Presentation() {
		
	}
	public Presentation(String uneDatePresentation, String leMoisPresenttation) {
		this.datePresentation = uneDatePresentation;
	}
	
	public String getDatePresentation() {
		return this.datePresentation;
	}
	
	public String getMoisPresenttation() {
		return moisPresenttation;
	}
	
}
