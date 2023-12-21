import javax.swing.*;
import java.awt.*;

public class V_toJSON {

	private JPanel toJSONPanel;
	
	private JLabel animateurLabel;
	private JLabel catalogueLabel;
	private JLabel conferenceLabel;
	
	private JEditorPane editorPaneAnimateur;
	private JEditorPane editorPaneCatalogue;
	private JEditorPane editorPaneConference;

	public V_toJSON(String JSONStringAnimateur,String JSONStringCatalogue,String JSONStringConference) {
		
		toJSONPanel = new JPanel();
		
		animateurLabel = new JLabel("Animateur :");
		editorPaneAnimateur = new JEditorPane("text/html",JSONStringAnimateur);
		
		catalogueLabel = new JLabel("Catalogue :");
		editorPaneCatalogue = new JEditorPane("text/html",JSONStringCatalogue);
		
		conferenceLabel = new JLabel("Conference :");
		editorPaneConference = new JEditorPane("text/html",JSONStringConference);
		
		toJSONPanel.add(animateurLabel);
		toJSONPanel.add(editorPaneAnimateur);
		toJSONPanel.add(catalogueLabel);
		toJSONPanel.add(editorPaneCatalogue);
		toJSONPanel.add(conferenceLabel);
		toJSONPanel.add(editorPaneConference);
		
	}
	
	public JPanel getToJSONPanel() {
		return this.toJSONPanel;
	}
	
}
