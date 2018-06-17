package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		/**
		 * Méthode de type String format() implémentée via "default" dans l'interface
		 * Utilisation de la méthode .size pour calculer le nombre de personne de la liste 
		 * @return une chaîne de la forme [<nb_personnes> persons], exemple de résultat : "[14 persons]"
		 */
		default String format() {
			List<Person> persons = findAll();
			int sumPersons = persons.size();
			return "[" + sumPersons + " persons]";
		}
	}
	// end::IDao[]

	// tag::DaoA[]
	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}

		/**
		 * Redéfinit la méthode String format(), l'implémentation réutilise la méthode format() de l'interface
		 * @return une chaîne de la forme DaoA[<nb_personnes> persons] exemple de résultat : "DaoA[14 persons]"
		 */
		public String format() {
			return "DaoA" + IDao.super.format();
		}

	}
	// end::DaoA[]

	@Test
	public void test_daoA_format() throws Exception {

		DaoA daoA = new DaoA();

		// invoque la méthode format() pour que le test soit passant
		String result = daoA.format();

		"DaoA[20 persons]".equals(result);
	}
}
