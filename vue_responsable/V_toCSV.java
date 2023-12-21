import javax.swing.*;

public class V_toCSV extends JPanel {

	private JPanel toCSVPanel;
	private JLabel animateurLabel;
	private JEditorPane editorPaneAnimateur;
	
	public V_toCSV(String csvStringAnimateur) {
		
		toCSVPanel = new JPanel();
		
		animateurLabel  = new JLabel("Animateur :");
		editorPaneAnimateur = new JEditorPane("text/html",csvStringAnimateur);
		
		
		toCSVPanel.add(animateurLabel);
		toCSVPanel.add(editorPaneAnimateur);
		
	}
	
	public JPanel getToCSVPanel() {
		return this.toCSVPanel;
	}
}
