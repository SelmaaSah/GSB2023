import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

public class V_statConferenceChoix extends JPanel{

	private JPanel statConferenceChoixPanel;
	private JLabel titreLabel;
	
	private JLabel choixLabel;
	private JComboBox<String> dateComboBox;
	
	private JButton statConferencetnBtn;
	
	public V_statConferenceChoix(ArrayList<Conference> dateConference) {
		
		statConferenceChoixPanel = new RoundedPanel(20);
		statConferenceChoixPanel.setBackground(Color.white);
		titreLabel = new JLabel("Les statistiques de presentation : ");
		choixLabel = new JLabel("Choisissez un mois pour visualiser les statistiques ");
		statConferencetnBtn = new JButton("Afficher");
		
		Font police = new Font("Courier New", Font.BOLD, 12);
		titreLabel.setFont(police);
		choixLabel.setFont(police);
		statConferencetnBtn.setFont(police);

		
		dateComboBox = new JComboBox<>();
		for (int i = 0; i < dateConference.size(); i++) {
			Conference conference = dateConference.get(i);
            String datePresentation = conference.getDateDeroulement()+ " - " + conference.getNomAnimateur();
            dateComboBox.addItem(datePresentation);
        }
		
		statConferenceChoixPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(10, 10, 10, 10);
	    
		statConferenceChoixPanel.add(titreLabel, gbc);
		gbc.gridy++;
		statConferenceChoixPanel.add(choixLabel, gbc);
		gbc.gridy++;
		statConferenceChoixPanel.add(dateComboBox, gbc);
		gbc.gridy++;
		statConferenceChoixPanel.add(statConferencetnBtn, gbc);
	}
	public JPanel getStatPresentationChoixPanel() {
		return statConferenceChoixPanel;
	}

	public JComboBox getDateComboBox() {
		return dateComboBox;
	}
	
	public JButton getStatConferenceBtn() {
		return this.statConferencetnBtn;
	}
}
