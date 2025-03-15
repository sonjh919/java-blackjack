package blackjack.participant;

public class Batting {
    private final int batting;

    public static Batting from(int batting){
        return new Batting(batting);
    }

    private Batting(int batting) {
        this.batting = batting;
    }

    public int getBatting() {
        return batting;
    }
}
