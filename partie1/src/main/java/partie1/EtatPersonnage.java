package partie1;

public abstract class EtatPersonnage {
    protected Personnage personnage;

    public EtatPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public abstract String attaquer(String cible);
    public abstract String recevoirPoison();
    public abstract String mourir();
}

class EtatVivant extends EtatPersonnage {
    public EtatVivant(Personnage personnage) { super(personnage); }

    @Override
    public String attaquer(String cible) {
        return personnage.getNom() + " attaque " + cible + ".";
    }

    @Override
    public String recevoirPoison() {
        return personnage.getNom() + " est empoisonné !";
    }

    @Override
    public String mourir() {
        return personnage.getNom() + " est mort.";
    }
}

class EtatEmpoisonne extends EtatPersonnage {
    public EtatEmpoisonne(Personnage personnage) { super(personnage); }

    @Override
    public String attaquer(String cible) {
        return personnage.getNom() + " attaque " + cible + ". "
             + personnage.getNom() + " perd 10 PV (poison)";
    }

    @Override
    public String recevoirPoison() {
        return "Déjà empoisonné.";
    }

    @Override
    public String mourir() {
        return personnage.getNom() + " est mort.";
    }
}

class EtatMort extends EtatPersonnage {
    public EtatMort(Personnage personnage) { super(personnage); }

    @Override
    public String attaquer(String cible) {
        return "Action impossible, " + personnage.getNom() + " est mort.";
    }

    @Override
    public String recevoirPoison() {
        return "Action impossible, " + personnage.getNom() + " est mort.";
    }

    @Override
    public String mourir() {
        return "Action impossible, " + personnage.getNom() + " est mort.";
    }
}