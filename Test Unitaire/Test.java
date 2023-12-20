

import static org.junit.Assert.assertTrue;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class Test {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@org.junit.jupiter.api.Test
//	void testConnexionBDD() {
//		Assert.assertNotNull("Erreur Connexion BDD", Modele.connexionBDD());
//	}
	
//	void testUserExiste() {
//		Assert.assertNotNull("L'utilisateur n'existe pas",Modele.existeUser("kayoub", "123"));
//	}
	
//	void testGetLesConferences() {
//		Assert.assertNotNull("La fonction ne fonctionne pas", Modele.getLesConferences());
//	}
//	
//	void testGetLesAnimateur() {
//		Assert.assertNotNull("La fonction ne fonctionne pas", Modele.getLesAnimateur());
//	}
	
//    void testInsererNvConference() {
//        // Données de test
//        String theme = "Modifier pour ecrire ce que l'on veut";
//        String dateDeroulement = "2023-12-20";
//        int idAnimateur = 1;
//
//        // Appel de la fonction 
//        Modele.insererNvConference(theme, dateDeroulement, idAnimateur);
//	}
	
//    void testinsertNvUtilisateur() {
//        // Données de test
//        String nom = "Rolland";
//        String prenom = "G";
//        String login = "Grolland";
//        String mdp = "123";
//        String typeVisiteur = "Animateur";
//
//
//        // Appel de la fonction
//        Modele.insertNvUtilisateur(nom, prenom, login, mdp, typeVisiteur);
//	}
	
	void testSupprimerUtilisateur() {
	    // Données de test
	    int idUserASupprimer = 6; // id d'un user

	    // Appel de la fonction à tester
	    boolean resultat = Modele.getSupprimerUnUtilisateur(idUserASupprimer);

	    // Verification de la reussite de la suppression
	    Assert.assertTrue(resultat);
	}
	

	

	
	
	

}
