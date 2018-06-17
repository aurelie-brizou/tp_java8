package java8.ex06;


import java8.data.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // tag::formatAge[]
      
    /**
     * @param supplier
     * @return une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
     */
    String formatAge(Supplier<Person> supplier) {
        return "[age="+ supplier.get().getAge() +"]";
    }
    
    // end::formatAge[]


    @Test
    public void test_supplier_formatAge() throws Exception {
        // compléte le test unitaire pour qu'il soit passant
        String result = formatAge(() -> new Person("Flip", "Flop", 35, "bretagne"));

        assert result.equals("[age=35]");
    }

    @Test
    public void test_supplier_requireNonNull() throws Exception {

        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("require non null object");

        // compléte le test unitaire pour qu'il soit passant
        Supplier<String> supplier = () -> "non null";

        // Avec un paramètre null, cette méthode déclenche un NullPointerException
        Objects.requireNonNull(null, supplier);
    }

}
