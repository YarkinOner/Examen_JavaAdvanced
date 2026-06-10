package partie4;

import partie2.Paire;
import java.io.*;
import java.util.*;

public class ScoreManager {

    public static void sauvegarder(String fichier, List<Paire<String, Integer>> scores)
            throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            for (Paire<String, Integer> score : scores) {
                writer.write(score.getFirst() + "," + score.getSecond() + "\n");
            }
        }
    }

    public static List<Paire<String, Integer>> charger(String fichier)
            throws IOException {
        List<Paire<String, Integer>> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                try {
                    String[] parts = ligne.split(",");
                    if (parts.length == 2) {
                        scores.add(new Paire<>(parts[0], Integer.parseInt(parts[1].trim())));
                    }
                } catch (Exception e) {
                }
            }
        }
        return scores;
    }
}