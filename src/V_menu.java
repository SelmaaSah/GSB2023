import java.awt.*;
import javax.swing.*;

/**
 * La classe V_menu représente la barre de menus de l'application.
 */
public class V_menu extends JMenuBar {

    // Les éléments de la barre de menus
    private JMenuBar menu;

    private JMenu menuFilm;
    private JMenuItem menuVoirFilm;
    private JMenuItem menuAjoutFilm;
    private JMenuItem menuModifierFilm;
    private JMenuItem menuSupprimerFilm;

    private JMenu menuLogs;
    private JMenuItem menuVoirLogs;

    private JMenu menuActeur;
    private JMenuItem menuVoirActeur;

    /**
     * Constructeur de la classe V_menu.
     * Initialise la barre de menus avec ses éléments.
     */
    public V_menu() {
        // Instanciation de la barre de menus
        menu = new JMenuBar();

        // Instanciation des menus et sous-menus
        menuFilm = new JMenu("FILM");
        menuVoirFilm = new JMenuItem("Voir les Films");
        menuAjoutFilm = new JMenuItem("Ajouter un Film");
        menuModifierFilm = new JMenuItem("Modifier un Film");
        menuSupprimerFilm = new JMenuItem("Supprimer un Film");

        menuLogs = new JMenu("LOGS");
        menuVoirLogs = new JMenuItem("Voir les logs");

        menuActeur = new JMenu("Acteur");
        menuVoirActeur = new JMenuItem("Voir les Acteurs");

        // Ajout des menus à la barre de menus
        setLayout(new BorderLayout());
        add(menu);
        menu.add(menuFilm);
        menu.add(menuLogs);
        menu.add(menuActeur);

        // Ajout des sous-menus aux menus
        menuFilm.add(menuVoirFilm);
        menuFilm.add(menuAjoutFilm);
        menuFilm.add(menuModifierFilm);
        menuFilm.add(menuSupprimerFilm);

        menuLogs.add(menuVoirLogs);

        menuActeur.add(menuVoirActeur);
    }

    // Méthodes pour obtenir les éléments de la barre de menus

    public JMenuBar getMenu() {
        return menu;
    }

    public JMenuItem getMenuVoirFilm() {
        return menuVoirFilm;
    }

    public JMenuItem getMenuVoirLogs() {
        return menuVoirLogs;
    }

    public JMenuItem getMenuAjoutFilm() {
        return menuAjoutFilm;
    }

    public JMenuItem getMenuModifierFilm() {
        return menuModifierFilm;
    }

    public JMenuItem getMenuSupprimerFilm() {
        return menuSupprimerFilm;
    }

    public JMenuItem getMenuVoirSerie() {
        return menuVoirFilm;
    }

    public JMenuItem getMenuAjoutSerie() {
        return menuAjoutFilm;
    }

    public JMenuItem getMenuModifierSerie() {
        return menuModifierFilm;
    }

    public JMenuItem getMenuSupprimerSerie() {
        return menuSupprimerFilm;
    }

    public JMenuItem getMenuVoirActeur() {
        return menuVoirActeur;
    }
}