package partie1;

public interface Potion {
    int getPV();
    String getEffets();
}

class PotionDeBase implements Potion {
    @Override public int getPV()        { return 50; }
    @Override public String getEffets() { return "Soin de base"; }
}

abstract class PotionDecorator implements Potion {
    protected final Potion potion;

    public PotionDecorator(Potion potion) {
        this.potion = potion;
    }

    @Override public int getPV()        { return potion.getPV(); }
    @Override public String getEffets() { return potion.getEffets(); }
}

class AvecAntidote extends PotionDecorator {
    public AvecAntidote(Potion potion) { super(potion); }

    @Override public int getPV()        { return super.getPV(); }
    @Override public String getEffets() { return super.getEffets() + ", Antidote"; }
}

class AvecMana extends PotionDecorator {
    public AvecMana(Potion potion) { super(potion); }

    @Override public int getPV()        { return super.getPV() + 30; }
    @Override public String getEffets() { return super.getEffets() + ", Restauration de mana"; }
}