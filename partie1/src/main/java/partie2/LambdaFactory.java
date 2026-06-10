package partie2;

import java.util.function.Function;

public class LambdaFactory {

    public static Transformation<String> majusculeEtPrefixe() {
        return valeur -> ">> " + valeur.toUpperCase();
    }

    public static Transformation<Integer> factorielle() {
        return n -> {
            int result = 1;
            for (int i = 2; i <= n; i++)
                result *= i;
            return result;
        };
    }

    public static Function<Integer, Integer> fibonacci() {
        return n -> {
            if (n <= 0) return 0;
            if (n == 1) return 1;
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        };
    }
}