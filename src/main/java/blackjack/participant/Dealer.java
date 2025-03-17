package blackjack.participant;

import blackjack.card.Hand;
import java.util.Map;

public class Dealer extends Participant {
    private static final int DEALER_DRAW_THRESHOLD = 16;

    public static Dealer create() {
        return new Dealer();
    }

    private Dealer() {
        super();
    }

    public boolean isUnderThreshold() {
        return sum() <= DEALER_DRAW_THRESHOLD;
    }

    public int calculateProfit(Players players) {
        Map<Player, Integer> profitOfPlayer = players.calculateProfit(this);
        return profit(profitOfPlayer);
    }

    private static int profit(Map<Player, Integer> profitOfPlayer) {
        int sum = 0;
        for (Integer value : profitOfPlayer.values()) {
            sum += value;
        }
        return -sum;
    }

    @Override
    public Hand getFirstCard() {
        return hand.getExceptHidden();
    }

}
