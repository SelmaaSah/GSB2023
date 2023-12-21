import javax.swing.*;
import java.awt.*;

public class V_toJSON {

	private JPanel toJSONPanel;
	private JEditorPane editorPane;

	public V_toJSON(String JSONStringAnimateur,String JSONStringCatalogue,String JSONStringConference) {
		
		toJSONPanel = new JPanel();
		editorPane = new JEditorPane("text/html",JSONStringAnimateur);
		
		toJSONPanel.add(editorPane);
		
	}
	
	public JPanel getToJSONPanel() {
		return this.toJSONPanel;
	}
	
}
