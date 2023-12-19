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
	
	public V_statPresentationChoix(ArrayList<Presentation> lesDatePresentation) {
		
		statPresentationChoixPanel = new JPanel();
		titreLabel = new JLabel("Les statistiques de Presentation : ");
		choixLabel = new JLabel("Choississez le mois pour les statistiques ");
		
		dateComboBox = new JComboBox<>();
		for (int i = 0; i < lesDatePresentation.size(); i++) {
			Presentation presentation = lesDatePresentation.get(i);
            String datePresentation = presentation.getDatePresentation();
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
	}

	public JPanel getStatPresentationChoixPanel() {
		return statPresentationChoixPanel;
	}

	public JLabel getTitreLabel() {
		return titreLabel;
	}
	
}
