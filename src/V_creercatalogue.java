import javax.swing.*;
import java.awt.*;

public class V_creercatalogue extends JFrame {

    private JPanel panelcatalogue;
    private JLabel labelcatalogue;

    private JLabel datelbl;
    private JTextField datetf;

    private JLabel horrairelbl;
    private JTextField horrairetf;

    private JLabel dureelbl;
    private JTextField dureetf;

    private JLabel sallelbl;
    private JTextField salletf;

    private JLabel animateurlbl;
    private JTextField animateurtf;

    private JLabel nbPlaceslbl;
    private JTextField nbPlacetf;

    public V_creercatalogue() {

        panelcatalogue = new JPanel();
        labelcatalogue = new JLabel("CATALOGUE DES CONFERENCES : ");
        panelcatalogue.setPreferredSize(new Dimension (500,500));

        datelbl = new JLabel("Date : ");
        datetf = new JTextField("");
        datetf.setPreferredSize(new Dimension(120, 20));

        horrairelbl = new JLabel("Horraire : ");
        horrairetf = new JTextField("");
        horrairetf.setPreferredSize(new Dimension(120, 20));

        dureelbl = new JLabel("Duree prevue : ");
        dureetf = new JTextField("");
        dureetf.setPreferredSize(new Dimension(120, 20));

        sallelbl = new JLabel("Salle : ");
        salletf = new JTextField("");
        salletf.setPreferredSize(new Dimension(120, 20));

        animateurlbl = new JLabel("Animateur : ");
        animateurtf = new JTextField("");
        animateurtf.setPreferredSize(new Dimension(120, 20));

        nbPlaceslbl = new JLabel("Nombre de places Dispo : ");
        nbPlacetf = new JTextField("");
        nbPlacetf.setPreferredSize(new Dimension(120, 20));

        panelcatalogue.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 0); // Ajout d'un espace en haut

        // Ajout des composants au panel avec GridBagConstraints
        panelcatalogue.add(labelcatalogue, gbc);

        gbc.gridy++;
        panelcatalogue.add(datelbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(datetf, gbc);

        gbc.gridy++;
        panelcatalogue.add(horrairelbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(horrairetf, gbc);

        gbc.gridy++;
        panelcatalogue.add(dureelbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(dureetf, gbc);

        gbc.gridy++;
        panelcatalogue.add(sallelbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(salletf, gbc);

        gbc.gridy++;
        panelcatalogue.add(animateurlbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(animateurtf, gbc);

        gbc.gridy++;
        panelcatalogue.add(nbPlaceslbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(nbPlacetf, gbc);
    }

    public JPanel getPanelCatalogue() {
        return this.panelcatalogue;
    }
}
