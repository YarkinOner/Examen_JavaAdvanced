package partie4;

import java.util.*;
import java.util.regex.*;

public class ValidateurJeu {

    public static boolean pseudoValide(String pseudo) {
        return pseudo.matches("[a-zA-Z0-9_]{3,16}");
    }

    public static Map<String, Integer> extraireScores(String texte) {
        Map<String, Integer> scores = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(\\w+):(\\d+) points");
        Matcher matcher = pattern.matcher(texte);
        while (matcher.find()) {
            scores.put(matcher.group(1), Integer.parseInt(matcher.group(2)));
        }
        return scores;
    }

    public static String masquerNombres(String texte) {
        return texte.replaceAll("\\d+", "***");
    }
}