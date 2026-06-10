package partie3;

import java.lang.reflect.*;
import java.util.*;

public class Inspecteur {

    public static String getNomTable(Class<?> clazz) {
        Entite entite = clazz.getAnnotation(Entite.class);
        if (entite == null)
            throw new IllegalArgumentException("@Entite absent sur " + clazz.getName());
        return entite.table();
    }

    public static List<String> getColonnes(Class<?> clazz) {
        List<String> colonnes = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Colonne colonne = field.getAnnotation(Colonne.class);
            if (colonne != null) {
                String nom = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                colonnes.add(nom);
            }
        }
        return colonnes;
    }

    public static List<String> getColonnesObligatoires(Class<?> clazz) {
        List<String> colonnes = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Colonne colonne = field.getAnnotation(Colonne.class);
            if (colonne != null && !colonne.nullable()) {
                String nom = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                colonnes.add(nom);
            }
        }
        return colonnes;
    }

    public static List<String> getMethodesLoggables(Class<?> clazz, String niveau) {
        List<String> methodes = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            Loggable loggable = method.getAnnotation(Loggable.class);
            if (loggable != null && loggable.niveau().equals(niveau)) {
                methodes.add(method.getName());
            }
        }
        return methodes;
    }
}