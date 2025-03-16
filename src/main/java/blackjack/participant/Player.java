package blackjack.participant;

import static blackjack.Match.BLACKJACK;
import static blackjack.Match.DRAW;
import static blackjack.Match.LOSE;
import static blackjack.Match.WIN;

import blackjack.Match;
import blackjack.card.Hand;

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

    public Match calculateResult(Dealer dealer) {
        int playerSum = sum();
        int dealerSum = dealer.sum();

        if (isBlackjack()) {
            if (dealer.isBlackjack()) {
                return DRAW;
            }
            return BLACKJACK;
        }

        if ((!dealer.isBust() && dealerSum > playerSum) || isBust()) {
            return LOSE;
        }

        if (dealerSum < playerSum || dealer.isBust()) {
            return WIN;
        }
        return DRAW;
    }

    public int calculateProfit(Dealer dealer) {
        return batting.calculateProfit(calculateResult(dealer));
    }

    public Name getName() {
        return name;
    }

    @Override
    public Hand getFirstCard() {
        return hand;
    }
}
