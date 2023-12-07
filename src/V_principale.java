import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class V_principale extends JFrame{
	
    private JPanel mainPanel;
   
    
    public V_principale() {
    	
    	this.setTitle("GSB2");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        
        // Instanciation des �l�ments
        mainPanel = new JPanel();
       

        //connexionBDD = new JLabel(Modele.connexionBDD());
        V_connexion connexionPanel = new V_connexion();
       
        // Changement de Couleur du Fond
        
        int redValue = 128;     // Valeur du composant rouge (entre 0 et 255)
        int greenValue = 162;   // Valeur du composant vert (entre 0 et 255)
        int blueValue = 205;  // Valeur du composant bleu (entre 0 et 255)

        Color customColor = new Color(redValue, greenValue, blueValue);
        
        mainPanel.setBackground(customColor);
        
        // Ajout du JPanel � la fen�tre principale
        
        getContentPane().add(mainPanel);
        
        // Affichage de la fen�tre
        this.setVisible(true);
    }

    // M�thode pour obtenir le JPanel principal
    public JPanel getMainPanel() {
        return mainPanel;
    }
}

