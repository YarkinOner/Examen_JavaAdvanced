package partie1;

public class Personnage {

    private final String nom;
    private final String classe;
    private int pv;
    private int mana;
    private String arme;
    private boolean estElite;

    private Personnage(Builder b) {
        this.nom      = b.nom;
        this.classe   = b.classe;
        this.pv       = b.pv;
        this.mana     = b.mana;
        this.arme     = b.arme;
        this.estElite = b.estElite;
    }

    public String getNom()    { return nom; }
    public String getClasse() { return classe; }
    public int getPv()        { return pv; }
    public int getMana()      { return mana; }
    public String getArme()   { return arme; }
    public boolean isElite()  { return estElite; }

    @Override
    public String toString() {
        return "Personnage{nom='" + nom + "', classe='" + classe +
               "', pv=" + pv + ", mana=" + mana +
               ", arme='" + arme + "', estElite=" + estElite + "}";
    }

    public static class Builder {

        private final String nom;
        private final String classe;
        private int pv          = 100;
        private int mana        = 50;
        private String arme     = "Poings";
        private boolean estElite = false;

        public Builder(String nom, String classe) {
            this.nom    = nom;
            this.classe = classe;
        }

        public Builder pv(int pv)          { this.pv = pv;       return this; }
        public Builder mana(int mana)      { this.mana = mana;   return this; }
        public Builder arme(String arme)   { this.arme = arme;   return this; }
        public Builder estElite(boolean v) { this.estElite = v;  return this; }

        public Personnage build() {
            if (nom == null || nom.isBlank())
                throw new IllegalArgumentException("Le nom est obligatoire.");
            if (classe == null || classe.isBlank())
                throw new IllegalArgumentException("La classe est obligatoire.");
            return new Personnage(this);
        }
    }
}