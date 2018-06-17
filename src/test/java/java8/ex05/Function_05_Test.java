package java8.ex05;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.function.Consumer;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

	//tag::functions[]
	// compléte la fonction
	// modifie le mot de passe en "secret"
	Consumer<Person> changePasswordToSecret = p -> p.setPassword("secret");

	// compléte la fonction
	// vérifie que l'age > 4 avec une assertion JUnit
	Consumer<Person> verifyAge = p -> assertTrue(p.getAge() > 4);

	// compléte la fonction
	// vérifie que le mot de passe est "secret" avec une assertion JUnit
	Consumer<Person> verifyPassword = p -> assertTrue(p.getPassword().equals("secret"));
	//end::functions[]


	@Test
	public void test_consumer() throws Exception {
		List<Person> personList = Data.buildPersonList();

		// invoque la méthode personList.forEach pour modifier les mots de passe en "secret"
		personList.forEach(changePasswordToSecret);

		// remplace la boucle for par l'invocation de la méthode forEach
		// utilise la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
		personList.forEach((verifyAge).andThen(verifyPassword));
	}
}
