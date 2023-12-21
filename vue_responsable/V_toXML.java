import javax.swing.*;
import java.awt.*;

public class V_toXML {

	private JPanel toXMLPanel;
	
	private JEditorPane editorPane;
	
	public V_toXML(String XMLStringAnimateur,String XMLStringCatalogue,String XMLStringConference ) {
		
		toXMLPanel = new JPanel();
		editorPane = new JEditorPane("text/html",XMLStringAnimateur);
		
		toXMLPanel.add(editorPane);
	}
	
	public JPanel getToXMLPanel() {
		return this.toXMLPanel;
	}
	
}
