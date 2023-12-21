import javax.swing.*;

public class V_toCSV extends JPanel {

	private JPanel toCSVPanel;
	private JLabel textArea;
	
	public V_toCSV(String csvString) {
		
		toCSVPanel = new JPanel();
		
		textArea = new JLabel(csvString);
		
		toCSVPanel.add(textArea);
	}
	
	public JPanel getToCSVPanel() {
		return this.toCSVPanel;
	}
}
