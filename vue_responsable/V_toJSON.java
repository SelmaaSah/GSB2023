import javax.swing.*;
import java.awt.*;

public class V_toJSON {

	private JPanel toJSONPanel;
	private JEditorPane editorPane;

	public V_toJSON(String JSONString) {
		
		toJSONPanel = new JPanel();
		editorPane = new JEditorPane("text/html",JSONString);
		
		toJSONPanel.add(editorPane);
		
	}
	
	public JPanel getToJSONPanel() {
		return this.toJSONPanel;
	}
	
}
