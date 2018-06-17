package java8.ex07;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

/**
 * Exercice 07 - java.util.function.IntBinaryOperator
 */
public class Function_07_Test {

    // tag::format[]

    /**
     * @param nb1
     * @param nb2
     * @param symbol
     * @param operator
     * @return une chaîne de caractères de la forme "(<nb1><symbol><nb2>)=<resultat>" ex:"(10+11)=21"
     */
    String format(int nb1, int nb2, String symbol, IntBinaryOperator operator) {
        return "("+ nb1 + symbol + nb2 + ")=" + operator.applyAsInt(nb1, nb2);
    }
    // end::format[]

    // définit sum pour que le test test_format_sum() soit passant
    IntBinaryOperator sum = (nb1, nb2) -> nb1 + nb2;

    @Test
    public void test_format_sum() throws Exception {

        String result = format(12, 13, "+", sum);

        assert result.equals("(12+13)=25");
    }

    // TODO définit substract afin que le test test_format_subtract() soit passant
    IntBinaryOperator substract = (nb1, nb2) -> nb1 - nb2;

    @Test
    public void test_format_subtract() throws Exception {

        String result = format(2, 3, "-", substract);

        assert result.equals("(2-3)=-1");
    }
}
