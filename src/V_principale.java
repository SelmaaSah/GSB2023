import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class V_principale extends JFrame{
	
    private JPanel mainPanel;
    private JLabel connexionBDD;
    
    public V_principale() {
    	
    	this.setTitle("SIO +");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        
        // Instanciation des �l�ments
        mainPanel = new JPanel();
        
       
        // Connexion � la base de donn�es et affichage du r�sultat dans un JLabel
        //connexionBDD = new JLabel(Modele.connexionBDD());
        V_connexion connexionPanel = new V_connexion();
       
        // Changement de Couleur du Fond
        mainPanel.setBackground(Color.ORANGE);
        
        // Ajout du JLabel � notre JPanel
        //connexionPanelmainPanel.add(connexionBDD);

        
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

