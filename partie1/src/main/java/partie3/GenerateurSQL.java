package partie3;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public class GenerateurSQL {

    public static String genererSelect(Class<?> clazz) {
        Entite entite = clazz.getAnnotation(Entite.class);
        if (entite == null)
            throw new IllegalArgumentException("@Entite absent sur " + clazz.getName());

        List<String> colonnes = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Colonne colonne = field.getAnnotation(Colonne.class);
            if (colonne != null) {
                String nom = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                colonnes.add(nom);
            }
        }

        return "SELECT " + String.join(", ", colonnes) + " FROM " + entite.table();
    }

    public static String genererInsert(Object objet) throws Exception {
        Class<?> clazz = objet.getClass();

        Entite entite = clazz.getAnnotation(Entite.class);
        if (entite == null)
            throw new IllegalArgumentException("@Entite absent sur " + clazz.getName());

        List<String> colonnes = new ArrayList<>();
        List<String> valeurs  = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            Colonne colonne = field.getAnnotation(Colonne.class);
            if (colonne != null) {
                field.setAccessible(true);
                Object valeur = field.get(objet);

                if (!colonne.nullable() && valeur == null)
                    throw new IllegalStateException("Champ obligatoire null : " + field.getName());

                String nom = colonne.nom().isEmpty() ? field.getName() : colonne.nom();
                colonnes.add(nom);

                if (valeur instanceof String)
                    valeurs.add("'" + valeur + "'");
                else
                    valeurs.add(String.valueOf(valeur));
            }
        }

        return "INSERT INTO " + entite.table() +
               " (" + String.join(", ", colonnes) + ")" +
               " VALUES (" + String.join(", ", valeurs) + ")";
    }
}