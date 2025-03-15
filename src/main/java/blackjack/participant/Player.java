package blackjack.participant;

public class Player extends Participant{
    private final Name name;
    private final Batting batting;

    public static Player of(Name name, Batting batting){
        return new Player(name, batting);
    }

    private Player(Name name, Batting batting) {
        super();
        this.name = name;
        this.batting = batting;
    }

    public Name getName() {
        return name;
    }

    public Batting getBatting() {
        return batting;
    }
}
