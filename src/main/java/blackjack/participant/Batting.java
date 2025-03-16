package blackjack.participant;

import blackjack.Match;

public class Batting {
    private final int batting;

    public static Batting from(final int batting) {
        return new Batting(batting);
    }

    private Batting(final int batting) {
        this.batting = batting;
    }

    public int calculateProfit(final Match match) {
        return (int) Math.floor(batting * match.getRate()) - batting;
    }

}
