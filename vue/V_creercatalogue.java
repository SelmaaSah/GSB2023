import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    private JLabel animateurlbl;

    private JLabel img;
    
    private JButton btnvld;


    private JComboBox<String> votreComboBoxCatalogue;
    private JComboBox<String> comboBoxLesSalles;


    public V_creercatalogue(ArrayList<Animateur>lesAnimateurs,ArrayList<Salle>lesSalles) {
    	
    	// Chargement de l'image depuis le fichier
    	ImageIcon logoGSB = new ImageIcon("image2/logogsb.png"); 

    	// Redimensionner l'image
    	Image image = logoGSB.getImage();
    	Image newImage = image.getScaledInstance(120, 55, Image.SCALE_SMOOTH); 

    	ImageIcon resizedIcon = new ImageIcon(newImage);
    	img = new JLabel(resizedIcon);

        panelcatalogue = new JPanel();
        labelcatalogue = new JLabel("CATALOGUE DES CONFERENCES : ");
        panelcatalogue.setPreferredSize(new Dimension (500,500));
        labelcatalogue.setForeground(new Color(128,162,205));

        datelbl = new JLabel("Date : ");
        datetf = new JTextField("");
        datetf.setPreferredSize(new Dimension(120, 20));

        horrairelbl = new JLabel("Heure : ");
        horrairetf = new JTextField("");
        horrairetf.setPreferredSize(new Dimension(120, 20));

        dureelbl = new JLabel("Duree prevue : ");
        dureetf = new JTextField("");
        dureetf.setPreferredSize(new Dimension(120, 20));

        sallelbl = new JLabel("Salle : ");
        comboBoxLesSalles= new JComboBox<>();
        for (int i = 0; i < lesSalles.size(); i++) {
            Salle salle = lesSalles.get(i);
            String representation = salle.getIdSalle() + " - " + salle.getNomSalle();
            comboBoxLesSalles.addItem(representation);
        }

        animateurlbl = new JLabel("Animateur : ");
        votreComboBoxCatalogue = new JComboBox<>();
        for (int i = 0; i < lesAnimateurs.size(); i++) {
            Animateur animateur = lesAnimateurs.get(i);
            String representation = animateur.getIdAnimateur() + " - " + animateur.getNomAnimateur();
            votreComboBoxCatalogue.addItem(representation);
        }


        btnvld = new JButton(" Valider ");

        
        panelcatalogue.setLayout(new GridBagLayout());
        
        
		Font police = new Font("Courier New", Font.BOLD, 13);
		datelbl.setFont(police);
		horrairelbl.setFont(police);
		dureelbl.setFont(police);
		sallelbl.setFont(police);
		labelcatalogue.setFont(police);
		animateurlbl.setFont(police);
		btnvld.setFont(police);

        
        
	    GridBagConstraints gbclogo = new GridBagConstraints();
	    gbclogo.gridx = 0;
	    gbclogo.gridy = 0;
	    gbclogo.anchor = GridBagConstraints.CENTER;
	    gbclogo.gridwidth = 2;
	    gbclogo.insets = new Insets(0, 0, 80, 0); // Ajout d'un espace en HAUT ET EN bas
	    panelcatalogue.add(img, gbclogo); 
	        
       
        
        
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
        panelcatalogue.add(comboBoxLesSalles, gbc);

        gbc.gridy++;
        panelcatalogue.add(animateurlbl, gbc);
        gbc.gridy++;
        panelcatalogue.add(votreComboBoxCatalogue, gbc);


        
        gbc.gridy++;
        panelcatalogue.add(btnvld, gbc);
        gbc.gridy++;
        panelcatalogue.add(btnvld, gbc);
        
    }

    public JPanel getPanelCatalogue() {
        return this.panelcatalogue;
    }
    
    public JTextField getDateF() {
        return this.datetf;
    }
    
    public JTextField getHorraire() {
        return this.horrairetf;
    }
    
    public JTextField getDuree() {
        return this.dureetf;
    }
    
    public JComboBox<String> getComboBoxLesSalles(){
    	return this.comboBoxLesSalles;
    }
    
    public JComboBox<String> getComboBoxCatalogue(){
    	return this.votreComboBoxCatalogue;
    }
    
    public JButton getBtnVld() {
        return this.btnvld;
    }
    
    
    
    
    
   
}