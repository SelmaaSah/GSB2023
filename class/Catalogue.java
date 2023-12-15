
public class Catalogue {

	//Les attributs 
	
	private String dateP;
	private int dureePrevue;
	private int sallenum;
	private int heure;
	private int animateurid;
	
	public Catalogue() {
		
	}

	public String getDateP() {
		return dateP;
	}

	public void setDateP(String dateP) {
		this.dateP = dateP;
	}

	public int getDureePrevue() {
		return dureePrevue;
	}

	public void setDureePrevue(int dureePrevue) {
		this.dureePrevue = dureePrevue;
	}

	public int getSallenum() {
		return sallenum;
	}

	public void setSallenum(int sallenum) {
		this.sallenum = sallenum;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getAnimateurid() {
		return animateurid;
	}

	public void setAnimateurid(int animateurid) {
		this.animateurid = animateurid;
	}

	public Catalogue(String dateP, int dureePrevue, int sallenum, int heure, int animateurid) {
		super();
		this.dateP = dateP;
		this.dureePrevue = dureePrevue;
		this.sallenum = sallenum;
		this.heure = heure;
		this.animateurid = animateurid;
	}
	
	
	
	
}
