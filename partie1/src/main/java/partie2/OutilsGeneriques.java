package partie2;

import java.util.List;
import java.util.NoSuchElementException;

public class OutilsGeneriques {


    public static <T extends Comparable<T>> T max(List<T> liste) {
        if (liste.isEmpty())
            throw new NoSuchElementException("Liste vide.");
        T max = liste.get(0);
        for (T element : liste) {
            if (element.compareTo(max) > 0)
                max = element;
        }
        return max;
    }


    public static <T> String concat(List<T> liste, String sep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < liste.size(); i++) {
            sb.append(liste.get(i));
            if (i < liste.size() - 1)
                sb.append(sep);
        }
        return sb.toString();
    }
}