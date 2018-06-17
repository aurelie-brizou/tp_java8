package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

	// tag::PersonToAccountMapper[]
	interface PersonToAccountMapper {
		Account map(Person p);
	}
	// end::PersonToAccountMapper[]

	// tag::PersonToFirstNametMapper[]
	interface PersonToStringeMapper {
		String map(Person p);
	}
	// end::PersonToFirstNametMapper[]

	// tag::map[]
	/**
	 * Méthode map() de type List<Account> implémentée pour transformer une liste de personnes en liste de comptes
	 * @param personList
	 * @param mapper
	 * @return liste de comptes
	 */
	private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
		List<Account> accounts = new ArrayList<Account>();
		for (Person p : personList) {
			Account c = mapper.map(p);
			accounts.add(c);
		}
		return accounts;
	}
	// end::map[]

	// tag::map[]

	/**
	 * Méthode map() de type List<Account> implémentée pour transformer une liste de personnes en liste de prénoms
	 * @param personList
	 * @param mapper
	 * @return liste de prénoms
	 */
	private List<String> map(List<Person> personList, PersonToStringeMapper mapper) {
		List<String> firstnames = new ArrayList<String>();
		for (Person p : personList) {
			String fn = mapper.map(p);
			firstnames.add(fn);
		}
		return firstnames;
	}
	// end::map[]


	// tag::test_map_person_to_account[]
	@Test
	public void test_map_person_to_account() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// transforme la liste de personnes en liste de comptes
		// tous les objets comptes ont un solde à 100 par défaut 
		PersonToAccountMapper mapper = p -> new Account(p, 100);


		List<Account> result = map(personList, mapper);

		assert result.size() == personList.size();
		for (Account account : result) {
			assert account.getBalance().equals(100);
			assert account.getOwner() != null;
		}
	}
	// end::test_map_person_to_account[]

	// tag::test_map_person_to_firstname[]
	@Test
	public void test_map_person_to_firstname() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// transforme la liste de personnes en liste de prénoms
		PersonToStringeMapper mapper = p -> p.getFirstname();

		List<String> result = map(personList, mapper);

		assert result.size() == personList.size();
		for (String firstname : result) {
			assert firstname.startsWith("first");
		}
	}
	// end::test_map_person_to_firstname[]
}
