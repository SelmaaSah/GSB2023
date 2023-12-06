import javax.swing.*;

public class V_accueil {
    private JPanel accueilPanel;
    private JLabel accueilLabel;

    public V_accueil() {
        accueilPanel = new RoundedPanel(15); // Ajustez le rayon des coins ici
        accueilLabel = new JLabel("Bienvenue : ");

        accueilPanel.add(accueilLabel);
    }

    public JPanel getAccueilPanel() {
        return this.accueilPanel;
    }
}
