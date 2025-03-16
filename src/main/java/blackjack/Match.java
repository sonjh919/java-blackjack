package blackjack;

import blackjack.participant.Dealer;
import blackjack.participant.Player;

public enum Match {
    WIN(2),
    BLACKJACK(2.5),
    DRAW(1),
    LOSE(0);

    private final double rate;

    Match(final double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static Match calculateResult(final Player player, final Dealer dealer) {
        int playerSum = player.sum();
        int dealerSum = dealer.sum();

        if (player.isBlackjack()) {
            if (dealer.isBlackjack()) {
                return DRAW;
            }
            return BLACKJACK;
        }

        if ((!dealer.isBust() && dealerSum > playerSum) || player.isBust()) {
            return LOSE;
        }

        if (dealerSum < playerSum || dealer.isBust()) {
            return WIN;
        }
        return DRAW;
    }
}