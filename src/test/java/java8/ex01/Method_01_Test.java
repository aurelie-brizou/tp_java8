package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();
        
        /**
         * Méthode de type int sumAge() implémentée via "default" dans l'interface
         * Utilisation d'une boucle for pour lister les personnes et additionner tous les ages
         * @return le résultat de l'addition des ages des personnes
         */
        default int sumAge() {
        	List<Person> persons = findAll();
        	int sum = 0;
        	for (Person p : persons) {
        		sum += p.getAge();
        	}
        	return sum;
        }
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // invoquer la méthode sumAge pour que le test soit passant
        int result = daoA.sumAge();

        assert result == 210;
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // invoquer la méthode sumAge pour que le test soit passant
        int result = daoB.sumAge();

        assert result == 5050;

    }
}
