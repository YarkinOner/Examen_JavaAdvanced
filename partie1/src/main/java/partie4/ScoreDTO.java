package partie4;

public class ScoreDTO {
    private String pseudo;
    private int score;

    public ScoreDTO(String pseudo, int score) {
        this.pseudo = pseudo;
        this.score  = score;
    }

    public String getPseudo() { return pseudo; }
    public int getScore()     { return score; }
}