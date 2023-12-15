import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class V_annulerConference extends JFrame{

	private JPanel annulerConferencePanel;
	private JLabel titreLabel;
	
	public V_annulerConference() {
		
		annulerConferencePanel = new JPanel();
		titreLabel = new JLabel("Annuler une Conference");
		
		annulerConferencePanel.add(titreLabel);
		
	}
	
	public JPanel getAnnulerConferencePanel() {
		return this.annulerConferencePanel;
	}
	
}
