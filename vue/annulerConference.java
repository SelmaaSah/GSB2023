import javax.swing.*;

public class annulerConference extends JFrame{

	private JPanel annulerConferencePanel;
	private JLabel titreLabel;
	
	public annulerConference() {
		
		annulerConferencePanel = new JPanel();
		titreLabel = new JLabel("Annuler une Conference");
		
		annulerConferencePanel.add(titreLabel);
		
	}
	
	public JPanel getAnnulerConferencePanel() {
		return this.annulerConferencePanel;
	}
	
}
