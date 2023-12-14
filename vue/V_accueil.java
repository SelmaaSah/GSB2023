import javax.swing.*;

public class V_accueil {
    private JPanel accueilPanel;
    private JLabel accueilLabel;
    private String nomUtilisateur;

    public V_accueil(String unNomUtilisateur) {
    	 this.nomUtilisateur = unNomUtilisateur;
    	 
        accueilPanel = new RoundedPanel(15); // Ajustez le rayon des coins ici
        accueilLabel = new JLabel("Bienvenue : " + nomUtilisateur);

        accueilPanel.add(accueilLabel);
    }

    public JPanel getAccueilPanel() {
        return this.accueilPanel;
    }
}
