package partie4;

import partie2.Paire;
import java.util.*;
import java.util.stream.*;

public class ScoreController {

    private static final String FICHIER = "scores.csv";

    public String getTop(int limit) {
        try {
            List<Paire<String, Integer>> scores = ScoreManager.charger(FICHIER);
            return scores.stream()
                    .sorted((a, b) -> b.getSecond() - a.getSecond())
                    .limit(limit)
                    .map(p -> p.getFirst() + ":" + p.getSecond())
                    .collect(Collectors.joining(","));
        } catch (Exception e) {
            return "";
        }
    }

    public String add(ScoreDTO dto) {
        try {
            List<Paire<String, Integer>> scores = new ArrayList<>();
            try {
                scores = ScoreManager.charger(FICHIER);
            } catch (Exception ignored) {}
            scores.add(new Paire<>(dto.getPseudo(), dto.getScore()));
            ScoreManager.sauvegarder(FICHIER, scores);
            return "OK";
        } catch (Exception e) {
            return "ERREUR";
        }
    }
}