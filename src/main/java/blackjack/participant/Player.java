package blackjack.participant;

import static blackjack.match.Match.calculateResult;

import blackjack.card.Hand;

public class Player extends Participant {
    private final Name name;
    private final Batting batting;

    public static Player of(final Name name, final Batting batting) {
        return new Player(name, batting);
    }

    private Player(final Name name, final Batting batting) {
        super();
        this.name = name;
        this.batting = batting;
    }

    public int calculateProfit(final Dealer dealer) {
        return batting.calculateProfit(calculateResult(this, dealer));
    }

    public Name getName() {
        return name;
    }

    @Override
    public Hand getFirstCard() {
        return hand;
    }
}
