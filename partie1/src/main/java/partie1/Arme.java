package partie1;

public interface Arme {
    String nom();
    int degats();
}

class Epee implements Arme {
    @Override public String nom()   { return "Épée"; }
    @Override public int degats()   { return 80; }
}

class Arc implements Arme {
    @Override public String nom()   { return "Arc"; }
    @Override public int degats()   { return 60; }
}

abstract class Forgeron {

    public abstract Arme forger();

    public final String presenterArme() {
        Arme arme = forger();
        return "Arme forgée : " + arme.nom() + " (" + arme.degats() + " dégâts)";
    }
}

class ForgeronEpee extends Forgeron {
    @Override
    public Arme forger() { return new Epee(); }
}

class ForgeronArc extends Forgeron {
    @Override
    public Arme forger() { return new Arc(); }
}