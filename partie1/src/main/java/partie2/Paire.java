package partie2;

public class Paire<A, B> {

    private final A first;
    private final B second;

    public Paire(A first, B second) {
        this.first  = first;
        this.second = second;
    }

    public A getFirst()  { return first; }
    public B getSecond() { return second; }

    public Paire<B, A> swap() {
        return new Paire<>(second, first);
    }

    @Override
    public String toString() {
        return "Paire(" + first + ", " + second + ")";
    }
}