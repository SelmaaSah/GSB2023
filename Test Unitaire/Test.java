

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
	
	void testGetLesConferences() {
		Assert.assertNotNull("La fonction ne foncitonne pas", Modele.getLesConferences());
	}
	
	void testGetLesAnimateur() {
		Assert.assertNotNull("La fonction ne foncitonne pas", Modele.getLesAnimateur());
	}

}
