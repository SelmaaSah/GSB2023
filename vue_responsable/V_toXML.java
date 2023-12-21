import javax.swing.*;
import java.awt.*;

public class V_toXML {

	private JPanel toXMLPanel;
	
	private JLabel animateurLabel;
	private JLabel catalogueLabel;
	private JLabel conferenceLabel;
	
	private JEditorPane editorPaneAnimateur;
	private JEditorPane editorPaneCatalogue;
	private JEditorPane editorPaneConference;
	
	public V_toXML(String XMLStringAnimateur,String XMLStringCatalogue,String XMLStringConference ) {
		
		toXMLPanel = new JPanel();
		
		animateurLabel  = new JLabel("Animateur :");
		editorPaneAnimateur = new JEditorPane("text/html",XMLStringAnimateur);
		
		catalogueLabel  = new JLabel("Catalogue :");
		editorPaneAnimateur = new JEditorPane("text/html",XMLStringCatalogue);
		
		conferenceLabel  = new JLabel("Conference :");
		editorPaneAnimateur = new JEditorPane("text/html",XMLStringConference);
		
		toXMLPanel.add(animateurLabel);
		toXMLPanel.add(editorPaneAnimateur);
		toXMLPanel.add(catalogueLabel);
		toXMLPanel.add(editorPaneAnimateur);
		toXMLPanel.add(conferenceLabel);
		toXMLPanel.add(editorPaneAnimateur);
	}
	
	public JPanel getToXMLPanel() {
		return this.toXMLPanel;
	}
	
}
