import java.awt.Color;
import javax.swing.*;

/**
 * La classe V_erreurConnexion représente la vue pour afficher un message d'erreur lors d'une tentative de connexion infructueuse.
 */
public class V_erreurConnexion {

    // Les composants de l'interface utilisateur
    private JPanel erreurConnexionPanel;
    private JLabel erreurConnexionLabel;

    /**
     * Constructeur de la classe V_erreurConnexion.
     * Initialise les composants de l'interface utilisateur pour afficher un message d'erreur.
     */
    public V_erreurConnexion() {
        // Instanciation du panneau d'erreur de connexion
        erreurConnexionPanel = new JPanel();
        erreurConnexionLabel = new JLabel("Mot de passe Incorrect");

        // Configuration des couleurs
        erreurConnexionPanel.setBackground(Color.red);
        erreurConnexionLabel.setForeground(Color.white);

        // Ajout du label au panneau d'erreur de connexion
        erreurConnexionPanel.add(erreurConnexionLabel);
    }

    /**
     * Obtient le panneau d'erreur de connexion.
     * @return Le panneau d'erreur de connexion.
     */
    public JPanel getErreurConnexionPanel() {
        return erreurConnexionPanel;
    }
}