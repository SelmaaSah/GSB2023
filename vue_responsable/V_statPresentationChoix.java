import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class V_statPresentationChoix extends JPanel{
	
	private JPanel statPresentationChoixPanel;
	private JLabel titreLabel;
	
	private JLabel choixLabel;
	private JComboBox<String> dateComboBox;
	
	private JButton statPressentatonBtn;
	
	public V_statPresentationChoix(ArrayList<Presentation> lesDatePresentation) {
		
		statPresentationChoixPanel = new RoundedPanel(20);
		statPresentationChoixPanel.setBackground(Color.white);
		titreLabel = new JLabel("Les statistiques de presentation : ");
		choixLabel = new JLabel("Choisissez un mois pour visualiser les statistiques ");
		statPressentatonBtn = new JButton("Afficher");
		
		Font police = new Font("Courier New", Font.BOLD, 12);
		titreLabel.setFont(police);
		choixLabel.setFont(police);
		statPressentatonBtn.setFont(police);

		
		dateComboBox = new JComboBox<>();
		for (int i = 0; i < lesDatePresentation.size(); i++) {
			Presentation presentation = lesDatePresentation.get(i);
            String datePresentation = presentation.getDatePresentation()+ " - " +presentation.getMoisPresenttation();
            dateComboBox.addItem(datePresentation);
        }
		
		statPresentationChoixPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    
		statPresentationChoixPanel.add(titreLabel, gbc);
		gbc.gridy++;
		statPresentationChoixPanel.add(choixLabel, gbc);
		gbc.gridy++;
		statPresentationChoixPanel.add(dateComboBox, gbc);
		gbc.gridy++;
		statPresentationChoixPanel.add(statPressentatonBtn, gbc);
	}

	public JPanel getStatPresentationChoixPanel() {
		return statPresentationChoixPanel;
	}

	public JComboBox getDateComboBox() {
		return dateComboBox;
	}
	
	public JButton getStatPressentatonBtn() {
		return this.statPressentatonBtn;
	}
	
}
