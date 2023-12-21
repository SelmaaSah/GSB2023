import java.awt.*;
import javax.swing.*;

/**
 * La classe V_menu repr�sente la barre de menus de l'application.
 */
public class V_menuResp extends JMenuBar {

    // Les �l�ments de la barre de menus
    private JMenuBar menu;

    private JMenu stats;
    private JMenuItem consulterStats;
    private JMenuItem statConference;
    
    private JMenu secr;
    private JMenuItem ajtSecretaire;
    private JMenuItem afhSecretaire;

    
    
    private JMenu type;
    private JMenuItem toJSON;
    private JMenuItem toXML;
    private JMenuItem toCSV;
    
    
    private JMenuItem deconnexion;


    /**
     * Constructeur de la classe V_menu.
     * Initialise la barre de menus avec ses �l�ments.
     */
    public V_menuResp() {
        // Instanciation de la barre de menus
        menu = new JMenuBar();

        // Instanciation des menus et sous-menus
        stats = new JMenu("Statistiques");
        consulterStats = new JMenuItem("Statistiques Presentation");
        statConference = new JMenuItem("Statistiques Conferences");

        secr = new JMenu("Secretaire");
        ajtSecretaire = new JMenuItem("Inscrire un(e) secretaire");
        afhSecretaire = new JMenuItem("Afficher les secretaire");

        
        deconnexion = new JMenuItem("Deconnexion");
        
        type = new JMenu("type");
        toJSON = new JMenuItem("JSON");
        toXML = new JMenuItem("XML");
        toCSV = new JMenuItem("CSV");

        // Ajout des menus � la barre de menus
        add(menu);
        menu.add(stats);
        stats.add(consulterStats);
        stats.add(statConference);
        
        menu.add(secr);
        secr.add(ajtSecretaire);
        secr.add(afhSecretaire);
        
        menu.add(type);
        type.add(toCSV);
        type.add(toXML);
        type.add(toJSON);
        
        
        
        
        menu.add(deconnexion);
        menu.setVisible(true);
    }

    // M�thodes pour obtenir les �l�ments de la barre de menus

    public JMenuBar getMenu() {
        return menu;
    }
    
    public JMenuItem getMenuDeconnexion() {
        return deconnexion;
    }

    public JMenuItem getConsulterStats() {
        return consulterStats;
    }
    
    public JMenuItem getStatConference() {
        return statConference;
    }
    
    public JMenuItem getToJSON() {
        return toJSON;
    }

    public JMenuItem getToCSV() {
        return toCSV;
    }
    public JMenuItem getToXML() {
        return toXML;
    }
    public JMenuItem getAjtSecretaire() {
        return ajtSecretaire;
    }
    
    public JMenuItem getAfhSecretaire() {
        return afhSecretaire;
    }

}
