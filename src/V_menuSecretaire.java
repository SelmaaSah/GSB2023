import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class V_menuSecretaire extends JMenuBar {
    private JMenu catalogue;
    private JMenuItem creercatalogue;

    public V_menuSecretaire() {
        // Instanciation des menus et sous-menus
        catalogue = new JMenu("Catalogue");
        creercatalogue = new JMenuItem("Créer un catalogue");

        // Ajout des menus à la barre de menus
        add(catalogue);

        // Ajout des sous-menus aux menus
        catalogue.add(creercatalogue);
    }

    public JMenuBar getMenuSecretaire() {
        return this;  // Retourne directement l'instance de la barre de menus
    }
}
