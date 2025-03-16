package blackjack.participant;

import blackjack.Match;

public class Batting {
    private final int batting;

    public static Batting from(int batting) {
        return new Batting(batting);
    }

    private Batting(int batting) {
        this.batting = batting;
    }

    public int calculateProfit(Match match) {
        return (int) Math.floor(batting * match.getRate()) - batting;
    }

}
