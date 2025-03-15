package blackjack;

public class Player {
    private final Name name;
    private final Batting batting;

    public static Player of(Name name, Batting batting){
        return new Player(name, batting);
    }

    private Player(Name name, Batting batting) {
        this.name = name;
        this.batting = batting;
    }
}
