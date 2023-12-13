import java.awt.*;
import javax.swing.*;

public class V_ajouterConferences {
    private JPanel ajouterConferencePanel;
    private JLabel titreLabel;
    private JLabel themeLabel;
    private JTextField themeTextField;
    private JLabel dateDeroulementLabel;
    private JTextField dateDeroulementTextField;
    private JComboBox<String> votreComboBox;
    private JButton btnvld2;

    public V_ajouterConferences() {
        ajouterConferencePanel = new JPanel();
        ajouterConferencePanel.setPreferredSize(new Dimension(500, 500));

        themeLabel = new JLabel("Le thème de la conférence : ");
        themeTextField = new JTextField();
        themeTextField.setPreferredSize(new Dimension(150, 20));

        dateDeroulementLabel = new JLabel("La date du conférence :");
        dateDeroulementTextField = new JTextField();
        dateDeroulementTextField.setPreferredSize(new Dimension(150, 20));

        votreComboBox = new JComboBox<>(); // Vous pouvez ajouter des éléments à votre JComboBox ici

        titreLabel = new JLabel("Gerer les Conférences");
        
        votreComboBox = new JComboBox<>();
        
        btnvld2 = new JButton("Valider");

        
//      Faire une For pour recuperer le nom de l'animateur Requete SQL
        votreComboBox.addItem("chien");
        votreComboBox.addItem("chat");
        votreComboBox.addItem("lyon");

        ajouterConferencePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 0);

        ajouterConferencePanel.add(titreLabel, gbc);
        gbc.gridy++;
        ajouterConferencePanel.add(themeLabel, gbc);
        gbc.gridy++;
        ajouterConferencePanel.add(themeTextField, gbc);
        gbc.gridy++;
        ajouterConferencePanel.add(dateDeroulementLabel, gbc);
        gbc.gridy++;
        ajouterConferencePanel.add(dateDeroulementTextField, gbc);
        gbc.gridy++;
        ajouterConferencePanel.add(votreComboBox, gbc);  
        gbc.gridy++;
        ajouterConferencePanel.add(btnvld2, gbc);
    }

    public JPanel getAjouterConferencePanel() {
        return ajouterConferencePanel;
    }
    
    public JButton getButtonVld() {
        return this.btnvld2;
    }
    
    
    
    
}

