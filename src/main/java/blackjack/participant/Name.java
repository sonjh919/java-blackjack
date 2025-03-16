package blackjack.participant;

public class Name {
    private final String name;

    public static Name from(final String name) {
        return new Name(name);
    }

    private Name(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
