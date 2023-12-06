import java.awt.*;
import javax.swing.*;

/**
 * La classe V_menu représente la barre de menus de l'application.
 */
public class V_menuResp extends JMenuBar {

    // Les éléments de la barre de menus
    private JMenuBar menu;

    private JMenu stats;
    private JMenuItem consulterStats;


    /**
     * Constructeur de la classe V_menu.
     * Initialise la barre de menus avec ses éléments.
     */
    public V_menuResp() {
        // Instanciation de la barre de menus
        menu = new JMenuBar();

        // Instanciation des menus et sous-menus
        stats = new JMenu("FILM");
        consulterStats = new JMenuItem("Consulter les statistiques");


        // Ajout des menus à la barre de menus
        setLayout(new BorderLayout());
        add(menu);
        menu.add(stats);
        stats.add(consulterStats);
        menu.setVisible(true);

    }

    // Méthodes pour obtenir les éléments de la barre de menus

    public JMenuBar getMenu() {
        return menu;
    }

    public JMenuItem getStats() {
        return consulterStats;
    }

}
